package model;

import java.util.Map;

import model.items.Equipable;
import model.items.TakeableItem;
import model.occupation.Occupation;
import model.slots.Equipment;
import model.slots.Inventory;
import model.slots.InventoryEquipment;

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
	public int getStatValue(String key) {
		if (this.stats.containsKey(key)) return this.stats.get(key).getValue();
		return -1;
	}
	public int getSkillValue(String key) {
		if (this.skills.containsKey(key)) return this.skills.get(key).getSkillLevel();
		return -1;
	}
	
	
	//**************   INVENTORY  ********************************
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
	
	//*************  EQUIPMENT *************************
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
	
	public void setStatValue(String key, int value) {
		if (this.stats.containsKey(key)) this.stats.get(key).setValue(value);
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
