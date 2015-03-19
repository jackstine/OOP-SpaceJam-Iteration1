package model.spells;

import model.entity.Entity;

public class PlasmaRay extends BaneSpellSingle{
	private int damage = 15;
	private int mana = 12;

	public PlasmaRay(Entity entity) {
		super(entity);
	}

	public int getDamage() {
		return this.damage;
	}

	public int getManaRequirement() {
		return this.mana;
	}
	

}
