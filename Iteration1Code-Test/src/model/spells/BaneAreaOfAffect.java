package model.spells;

import model.entity.Entity;

public abstract class BaneAreaOfAffect extends SpellAreaOfEffect implements BaneSpell{

	public BaneAreaOfAffect(Entity entity) {
		super(entity);
	}
	
	//TODO   area effect spell thingy
}
