package model.spells;

import model.Entity.Entity;

public abstract class SpellSingleAffect implements Spellable{
	protected Entity entity;
	
	public SpellSingleAffect(Entity entity){
		this.entity = entity;
	}
	
	public abstract int getManaRequirement();
	public abstract Entity getEntity();

	public abstract void apply(Entity entityToAffect);
	
	public boolean able(){
		if ( this.getEntity().getMP() >= this.getManaRequirement())return true;
		else return false;
	}	
}
