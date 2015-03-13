package model.Entity;

import java.util.Map;

import model.Point;
import model.Skill;
import model.items.Equipable;
import model.items.TakeableItem;
import model.occupation.Occupation;
import model.slots.Equipment;
import model.slots.Inventory;
import model.slots.InventoryEquipment;
import model.stats.Stat;

public abstract class Entity {
	protected Map<String,Stat> stats; 
	protected Map<String,Skill> skills;
	protected Occupation occupation;
	protected String name;
	protected int direction;
	protected InventoryEquipment inventoryEquipment;
	
	// private GameMap map;
	// private Equipable equipment;
	
	// -------------------------------------------
	// Need to decide on what constructor we're using for Entity
	public Entity() {}
	
	public Entity(Occupation occupation) {
		this.occupation = occupation;
		occupation.createNecessities();
		this.stats = occupation.getStats();
		this.skills = occupation.getSkills();
		this.inventoryEquipment = new InventoryEquipment(new Inventory(),occupation.getEquipment());
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
	
	
	/**************   INVENTORY  ********************************/
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
	public void setStatValue(String key, int value) {
		if (this.stats.containsKey(key)) this.stats.get(key).setValue(value);
	}
	
	public int getStatValue(String key) {
		if (this.stats.containsKey(key)) return this.stats.get(key).getValue();
		return -1;
	}
	
	private int getSV(String stat){
		return this.stats.get(stat).getValue();
	}
	
	private void subSV(String stat,int change){
		int valueLeft = this.getSV(stat) - change;
		this.stats.get(stat).setValue(valueLeft);
	}
	
	private void addSV(String stat,int change){
		int valueLeft = this.getSV(stat) + change;
		this.stats.get(stat).setValue(valueLeft);
	}
	
	public int getAgility(){return this.getSV("Agility");}
	public int getExperience(){return this.getSV("Experience");}
	public int getHardiness(){return this.getSV("Hardiness");}
	public int getHP(){return this.getSV("HP");}
	public int getIntellect(){return this.getSV("Intellect");}
	public int getLives(){return this.getSV("Lives");}
	public int getMovement(){return this.getSV("Movement");}
	public int getMP(){return this.getSV("MP");}
	public int getLevel(){return this.getSV("Level");}
	public int getStrength(){return this.getSV("Strength");}
	public int getLife(){return this.getSV("Life");}
	public int getMana(){return this.getSV("Mana");}
	public int getOffensiveRating(){return this.getSV("DefensiveRating");}
	public int getDefensiveRating(){return this.getSV("DefensiveRating");}
	public int getArmorRating(){return this.getSV("ArmorRating");}
	
	public void subHP(int change){this.subSV("HP", change);}
	public void subMana(int change){this.subSV("Mana", change);}
	
	public void addHP(int change){this.addSV("HP", change);}
	public void addMana(int change){this.addSV("Mana", change);}
	
	public void incSkillValue(String key) {
		if (this.skills.containsKey(key)) this.skills.get(key).upgradeSkillLevel();
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public Occupation getOccupation() {
		return occupation;
	}
	
	// -------------------------------------------
	// not 1st iteration stuff
	private void attack() {
		//occupation.attack();
	}
	
	private void useAbility() {
		//occupation.useAbility();
	}
	// -------------------------------------------
}
