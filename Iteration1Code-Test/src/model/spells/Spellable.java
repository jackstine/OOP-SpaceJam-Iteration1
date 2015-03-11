package model.spells;

import model.Entity.Entity;

public interface Spellable {
	//so a spell will consume a certain amount of mana
	// so they have to be able to be performed, if they are able
	
	
	
	//maybe it needs to be boolean?
	public void affect(Entity entityToAffect);
	
	public boolean able();	
}