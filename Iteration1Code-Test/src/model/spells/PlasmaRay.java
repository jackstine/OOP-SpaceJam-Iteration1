package model.spells;

import utilities.PlasmaRaySoundEffect;
import utilities.SoundEffect;
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
	

	@Override
	public void makeSoundEffect() {
		SoundEffect e = new PlasmaRaySoundEffect();
	}
}
