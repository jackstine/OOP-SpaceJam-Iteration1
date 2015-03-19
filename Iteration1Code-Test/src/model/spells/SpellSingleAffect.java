package model.spells;

import model.entity.Entity;

public abstract class SpellSingleAffect implements Spellable{
	protected Entity entity;
	
	public SpellSingleAffect(Entity entity){
		this.entity = entity;
	}
	
	public abstract int getManaRequirement();
	
	public boolean able(){
		if ( this.getEntity().getMP() >= this.getManaRequirement()){
			return true;
		}
		else return false;
	}
	
	public Entity getEntity(){
		return this.entity;
	}
}
