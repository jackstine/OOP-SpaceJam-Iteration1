package model.visitor;

import model.items.AlchemistWeapon;
import model.items.Armor;
import model.items.Boots;
import model.items.Equipable;
import model.items.Gloves;
import model.items.Helmet;
import model.items.HunterWeapon;
import model.items.Leggings;
import model.items.Projectile;
import model.items.Shield;
import model.items.TakeableItem;
import model.items.TerminatorSingleWeapon;
import model.items.TerminatorTwoHandedWeapon;
import model.items.Weapon;
import model.slots.Equipment;
import model.slots.Inventory;
import model.slots.InventoryEquipment;

public class EquipVisitor implements EquipableVisitor{
	private Equipment equipment;
	private Inventory inventory;
	private InventoryEquipment ie;
	
	public EquipVisitor(InventoryEquipment ie){
		this.equipment = ie.getEquipment();
		this.inventory = ie.getInventory();
		this.ie = ie;
	}
	
	private void equipBack(Equipable temp, TakeableItem item){
		boolean itemExist = temp != null;
		if (itemExist) this.ie.equipEquipment(temp);
		this.inventory.findAndEquip(item);
	}

	public void accept(Armor armor){
		Equipable temp = this.equipment.unequip(armor);
		if (this.equipment.equip(armor)){
			this.inventory.findAndEquip(temp);
		}else{
			this.equipBack(temp, armor);
		}
	}

	public void accept(Leggings leggings){
		Equipable temp = this.equipment.unequip(leggings);
		if (this.equipment.equip(leggings)){
			this.inventory.findAndEquip(temp);
		}else{
			this.equipBack(temp, leggings);
		}
	}

	public void accept(Boots boots){
		Equipable temp = this.equipment.unequip(boots);
		if (this.equipment.equip(boots)){
			this.inventory.findAndEquip(temp);
		}else{
			this.equipBack(temp, boots);
		}
	}
	
	public void accept(Gloves gloves){
		Equipable temp = this.equipment.unequip(gloves);
		if (this.equipment.equip(gloves)){
			this.inventory.findAndEquip(temp);
		}else{
			this.equipBack(temp, gloves);
		}
	}

	public void accept(Projectile projectile){
		Equipable temp = this.equipment.unequip(projectile);
		if (this.equipment.equip(projectile)){
			this.inventory.findAndEquip(temp);
		}else{
			this.equipBack(temp, projectile);
		}
	}
	
	public void accept(Shield shield){
		Equipable temp = this.equipment.unequip(shield);
		if (this.equipment.equip(shield)){
			this.inventory.findAndEquip(temp);
		}else{
			this.equipBack(temp, shield);
		}
		
	}

	public void accept(Helmet helmet) {
		Equipable temp = this.equipment.unequip(helmet);
		if (this.equipment.equip(helmet)){
			this.inventory.findAndEquip(temp);
		}else{
			this.equipBack(temp, helmet);
		}
	}
	
	public void accept(TerminatorTwoHandedWeapon thw){
		Equipable tempShield = this.equipment.unequipShieldTHW();
		Equipable tempWeapon = this.equipment.unequipWeaponTHW();
		Equipable tempTHW = this.equipment.unequipTHW();
		if (this.equipment.equip(thw)){
			this.inventory.findAndEquip(tempShield);
			this.inventory.findAndEquip(tempWeapon);
			this.inventory.findAndEquip(tempTHW);
		}else{
			if (tempShield != null)
				this.ie.equipEquipment(tempShield);
			if (tempWeapon != null)
				this.ie.equipEquipment(tempWeapon);
			if (tempTHW != null)
				this.ie.equipEquipment(tempTHW);
			this.inventory.findAndEquip(thw);
		}
	}

	public void accept(HunterWeapon h) {
		this.equipWeapon(h);
	}

	public void accept(AlchemistWeapon a) {
		this.equipWeapon(a);
	}

	public void accept(TerminatorSingleWeapon t) {
		this.equipWeapon(t);
	}
	
	public void equipWeapon(Weapon weapon) {
		Equipable temp = this.equipment.unequip(weapon);
		if(this.equipment.equip(weapon)){
			this.inventory.findAndEquip(temp);
		}
		else{
			this.equipBack(temp, weapon);
		}
	}
}
	
