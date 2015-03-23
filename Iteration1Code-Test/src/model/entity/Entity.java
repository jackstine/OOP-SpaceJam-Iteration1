package model.entity;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Map;

import javax.swing.Timer;

import utilities.DeathSoundEffect;
import utilities.ImageProcessing;
import utilities.RNG;
import utilities.Scaling;
import utilities.SoundEffect;
import utilities.SpriteSheetUtility;
import view.AbilityView;
import model.Point;
import model.Skill;
import model.abilities.Abilities;
import model.abilities.Spell;
import model.abilities.Spellable;
import model.abilities.Spells;
import model.behavior.Behavior;
import model.behavior.RadialEntitySight;
import model.behavior.State;
import model.items.Equipable;
import model.items.TakeableItem;
import model.items.Weapon;
import model.occupation.Occupation;
import model.slots.Equipment;
import model.slots.Inventory;
import model.slots.InventoryEquipment;
import model.stats.EntityStats;
import model.visitor.WeaponVisitor;

public abstract class Entity implements Dieable{
	protected EntityStats stats; 
	protected Map<String,Skill> skills;
	protected Occupation occupation;
	protected String name;
	protected int direction;
	protected int gold;
	private String currMap="Main";
	protected InventoryEquipment inventoryEquipment;
	protected State preferredState = new State();
	protected State engagedState = new State();
	protected SoundEffect soundEffect;
	private BufferedImage[] spriteSheet;
	private BufferedImage image;
	private WeaponVisitor weaponVisitor= new WeaponVisitor(this);
	private boolean buyingMode = false;
	private RadialEntitySight sight;
	private Entity sellingPartner;
	private AbilityView abilityView;
	private boolean observationOn;
	
	//TODO change the spells so that they are only associated with Alchemists
	protected Abilities abilities;
	
	private Timer buffTime;
	private boolean buffed = false;
	
	public Entity(Occupation occupation) {
		this.occupation = occupation;
		gold = 0;
		occupation.createNecessities();
		this.stats = new EntityStats(occupation.getStats());
		this.skills = occupation.getSkills();
		this.inventoryEquipment = new InventoryEquipment(new Inventory(),occupation.getEquipment());
		SpriteSheetUtility util = occupation.getSpriteSheet();
		this.spriteSheet = (util.getSpriteArray());
		this.abilityView = occupation.getAbilityView();
		this.abilityView.setEntity(this);
		this.setabilities();
	}
	
	public void setabilities(){
		this.abilities = occupation.getAbilities();
		if (this.abilities != null)
			this.abilities.setEntity(this);
	}
	public boolean hasabilities() {
		if (this.abilities != null) return true;
		else return false;
	}
	

	public AbilityView getAbilitiesView() {
		return this.abilityView;
	}
	
	public BufferedImage getImage(){
			BufferedImage imageToDisplay = spriteSheet[direction];
			image= ImageProcessing.scaleImage(Scaling.AVATAR_WIDTH, Scaling.AVATAR_HEIGHT, imageToDisplay);
			return image;
	}
	
	public void kill(){
		this.preferredState.kill();
		this.engagedState.kill();
	}
	

	public void grantSight(Avatar avatar) {
		sight = new RadialEntitySight(avatar);
	}
	
	public RadialEntitySight getSight() {
		return sight;
	}

	public void buy(TakeableItem item){
		this.inventoryEquipment.equipInventory(item);
	}
	
	public void sellToPartner(TakeableItem itemToSell) {
		int basePrice = itemToSell.getBonus();
		this.makeGoldTransaction(basePrice+(this.getSkillValue("Bargain")*2));
		this.sellingPartner.buy(itemToSell);

	}
	
	/********************** O BEHAVE ****************************************/
	public void setPrefferedBehavior(Behavior behavior){
		this.preferredState.setState(behavior);
	}
	
	public void setEngageBehavior(Behavior behavior){
		this.engagedState.setState(behavior);
	}
	
	public void idle(){
		this.preferredState.perform(this);
	}

	public void engage(Entity entity){
		this.engagedState.perform(entity);
		this.preferredState.kill();
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}
	
	public int getDirection() {
		return direction;
	}
	public int getSkillValue(String key) {
		if (this.skills.containsKey(key)) return this.skills.get(key).getSkillLevel();
		return -1;
	}
	
	public int getGold(){
		return gold;
	}
	
	public void makeGoldTransaction(int amount){
		gold += amount;
	}
	
	
	/******************* INVENTORY  ********************************/
	public Inventory getInventory(){
		return inventoryEquipment.getInventory();
	}
	
	public void setInventory(Inventory inventory){
		this.inventoryEquipment.setInventory(inventory);
	}
	
	public boolean equipInventory(TakeableItem item){
		return this.inventoryEquipment.equipInventory(item);
	}
	
	public TakeableItem unequipInventorySlot(Point slotPoint){
		return this.inventoryEquipment.unequipInventory(slotPoint);
	}
	
	public boolean equipInventory(TakeableItem item, Point point){
		return this.inventoryEquipment.equipInventory(item,point);
	}
	
	public TakeableItem getInventorySlot(Point point){
		return this.inventoryEquipment.getInventorySlot(point);
	}
	
	/*************  EQUIPMENT *************************/
	public void setEquipment(Equipment equipment){
		this.inventoryEquipment.setEquipment(equipment);
	}
	
	public Equipment getEquipment(){
		return inventoryEquipment.getEquipment();
	}
	
	public void equip(Equipable item){
		this.inventoryEquipment.equipEquipment(item);
	}
	
	public TakeableItem unequipEquipment(Point point){
		return this.inventoryEquipment.unequipEquipment(point);
	}
	
	/********************** STATS ***********************/
	public String getStat(String s){
		return this.stats.getStat(s);
	}
	public EntityStats getStats(){
		return this.stats;
	}
	public void setStatValue(String key, int value) {
		this.stats.setStatValue(key, value);
	}
	
	public int getStatValue(String key) {
		return this.stats.getStatValue(key);
	}
	
	public void tempIncStat(String s, int value){
		if(buffed)return;
		buffed = true;
		int old = stats.getStatValue(s);
		this.stats.setStatValue(s, Math.max(0,old + value));
		buffTime = new Timer(500,new BuffTimer(old,s));
		buffTime.start();
	}
	
	public int getMP(){return this.stats.getMP();}
	public int getHP(){return this.stats.getHP();}
	
	public void subHP(int change){this.stats.subHP(change);}
	public void subMP(int change){this.stats.subMP(change);}
	
	public void addHP(int change){this.stats.addHP(change);}
	public void addMP(int change){this.stats.addMP(change);}
	
	public void addEXP(int change){this.stats.addEXP(change);}
	
	
	/******************** abilities ******************************/
	public Abilities getabilities(){
		return this.abilities;
	}
	public void setSelectedSpell(Point spell){
		this.abilities.setSelectedSpell(spell);
	}
	public Spellable getSelectedSpell(){
		return this.abilities.getSelectedSpell();
	}
	
	public void setObservation(){
		this.observationOn = true;
	}
	
	public void clearObservation(){
		this.observationOn = false;
	}
	
	public boolean getObservation(){
		return this.observationOn;
	}
	
	
	public void incSkillValue(String key) {
		if (this.skills.containsKey(key)) this.skills.get(key).upgradeSkillLevel();
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public String observation(int x, int d){
		String s = "Observation: \n";
		String[] info = {"Level","Life","HP", "Agility", "Strength",
				 "Intellect", "MP", "Hardiness"};
		int n = 0;
		for(int i = 0; i < x && i < 7; ++i){
			if(d!=0 && RNG.genRandDouble() > 1/d){
				n = RNG.generateRand(0,stats.getStatValue(info[i])+5);
			}
			else{
				n = stats.getStatValue(info[i]);
			}
			s += (info[i] + ":" + n + "\n");
		}
		return s;
	}
	
	public Occupation getOccupation() {
		return occupation;
	}
	
	public int attack(){
		int stat = stats.getOffensiveRating();
		System.out.println(stat);
		TakeableItem weapon = this.inventoryEquipment.getEquipment().getWeapon();
		if(weapon != null){
			weapon.accept(weaponVisitor);
			int skill = weaponVisitor.getSkill();
			return stat + ( (int) ( (stat * 0.2) * (2 * skill) ) );
		}
		else{
			return stat;
		}
	}
	
	public int defense() {
		return stats.getStatValue("DefensiveRating");
	}
	
	private void useAbility() {
		//occupation.useAbility();
	}
	// -------------------------------------------

	public String getCurrMap() {
		return currMap;
	}

	public void setCurrMap(String currMap) {
		this.currMap = currMap;
	}

	
	/*************   FIX THIS STUFF ***********************/
	public String getDialogue() {
		return "";
	}

	public void writeJournal(Object dialogue) {
		
	}
	
	public String diaryEntry() {
		return "This looks like "+toString()+"\nProbably has "+stats.getStatValue("HP")+"HP left\n";
	}
	
	public void setBuyingMode(){
		this.buyingMode = true;
	}
	
	public void resetBuyingMode(){
		this.buyingMode = false;
	}
	
	public boolean getBuyingMode(){
		return this.buyingMode;
	}

	public void setSellingPartner(Entity receiver) {
		this.sellingPartner = receiver;
	}
	
	public void resetSellingPartner(){
		this.sellingPartner = null;
	}

	public void revertEngageBehavior() {
		this.engagedState.revert();
	}
	
	public void polymorph(){
		int oldMovement= this.getStatValue("Movement");
		int changedMovement=2;
		this.setStatValue("Movement",changedMovement);
		buffTime = new Timer(500,new PolymorphTimer("Movement",oldMovement));
		makeAlternateSpriteArray();
		buffTime.start();
		
		
		
	}
	
	public abstract void makeDeathSoundEffect();
	
	
	
	public void makeAlternateSpriteArray() {
		SpriteSheetUtility util = occupation.getAlternateSpriteSheet();
		this.spriteSheet = (util.getSpriteArray());
	}
	
	
	public void restoreSpriteArray() {
		SpriteSheetUtility util = occupation.getSpriteSheet();
		this.spriteSheet = (util.getSpriteArray());
	}

	public void makeTransformedSpriteArray() {
		SpriteSheetUtility util = occupation.getTransformedSpriteSheet();
		this.spriteSheet = (util.getSpriteArray());
	}

	
	public class BuffTimer implements ActionListener {
		long start = System.currentTimeMillis();
		int value = 0;
		String stat = "";
		public BuffTimer(int value, String stat){
			this.value = value;
			this.stat = stat;
		}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			long timePassed = System.currentTimeMillis() - start;
			if(timePassed > 5000){
				stats.setStatValue(stat, value);
				buffed = false;
				buffTime.stop();
			}
			
		}

	}
	
	public class PolymorphTimer implements ActionListener {
		long start = System.currentTimeMillis();
		int value = 0;
		String stat = "";
		
		public PolymorphTimer(String stat, int value ){ //add third parameter
			this.value = value;
			this.stat=stat;
		}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			long timePassed = System.currentTimeMillis() - start;
			if(timePassed > 5000){
				stats.setStatValue(stat, value);
				buffed = false;
				buffTime.stop();
				restoreSpriteArray();
			}
			
		}

	}
	
}

