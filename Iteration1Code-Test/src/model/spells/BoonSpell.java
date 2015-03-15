package model.spells;

import model.Entity.Entity;

public abstract class BoonSpell implements Spellable{

	public void appply(Entity entityToAffect) {
		
	}
	
	public boolean able(Entity entity) {
		return false;
	}
}
