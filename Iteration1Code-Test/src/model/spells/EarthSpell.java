package model.spells;

import model.Entity.Entity;

public class EarthSpell extends BaneSpellSingle{
	private int damage = 12;
	private int mana = 11;

	public EarthSpell(Entity entity) {
		super(entity);
	}
	public int getDamage() {
		return this.damage;
	}

	public int getManaRequirement() {
		return mana;
	}
}
