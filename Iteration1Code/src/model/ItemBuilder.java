package model;

import java.io.Serializable;

public class ItemBuilder implements Serializable{
	public Armor buildArmor(int defense, String image) {
		Armor armor = new Armor(defense, image);
		return armor;
	}
	
	public Weapon buildWeapon(int attack, String image) {
		Weapon weapon = new Weapon(attack, image);
		return weapon;
	}
	/*
	 * May build consumable class later
	public Consumable buildConsumerable(int health, String image) {
		Consumable consumable = new Consumable(health, image);
		return consumable;
	}
	*/
}
