package model.spells;

import utilities.BlazeSoundEffect;
import utilities.SoundEffect;
import model.entity.Entity;

public class FireSpell extends BaneSpellSingle{
	// for now we will have a spell that will have a constant damage applied to it
	// later we can use the entity that is associated with the spell to change the damage
	
	//so these values will be subject to change when the skill of the avatar changes
	private int damage = 10;
	private int manaRequirement = 10;

	//another thing to note, Entities can not attack with spells, so only 
	//Occupations of Alchemist types can
	public FireSpell(Entity entity) {
		super(entity);
	}

	public int getDamage() {
		return this.damage;
	}

	public int getManaRequirement() {
		return this.manaRequirement;
	}

	public void makeSoundEffect() {
		SoundEffect e = new BlazeSoundEffect();
	}
}
