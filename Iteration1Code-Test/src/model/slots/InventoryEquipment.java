package model.slots;

import model.Point;
import model.items.Equipable;
import model.items.TakeableItem;
import model.visitor.EquipVisitor;

public class InventoryEquipment {
	private Equipment equipment;
	private Inventory inventory;
	private EquipVisitor visitor;

	
	public InventoryEquipment(Inventory inventory, Equipment equipment){
		this.inventory = inventory;
		this.equipment = equipment;
		this.visitor = new EquipVisitor(this);
	}
	
	public Equipment getEquipment(){
		return this.equipment;
	}
	
	public void setEquipment(Equipment equipment){
		this.equipment = equipment;
		this.visitor.setEquipment(equipment);
	}
	
	public void equipEquipment(Equipable item){
		item.accept(visitor);
	}
	
	public TakeableItem unequipEquipment(Point point){
		return this.equipment.unequipSlot(point);
	}
	
	//****************** INVENTORY ************************
	public void setInventory(Inventory inventory){
		this.inventory = inventory;
		this.visitor.setInventory(inventory);
	}
	
	public boolean equipInventory(TakeableItem item){
		return this.inventory.findAndEquip(item);
	}
	public boolean equipInventory(TakeableItem item,Point point){
		return this.inventory.equip(point, item);
	}
	
	public TakeableItem unequipInventory(Point point){
		return this.inventory.unequip(point);
	}
	
	public Inventory getInventory(){
		return this.inventory;
	}
}
