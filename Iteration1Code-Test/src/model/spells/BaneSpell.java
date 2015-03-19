package model.spells;

import model.Entity.Entity;

public interface BaneSpell{
	//does damage to a NPC, is used to destroy things, cause mayhem
	public int getDamage();
	
	abstract void applyDamage(Entity entity);
}
