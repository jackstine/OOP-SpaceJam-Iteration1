package model.abilities;

import model.entity.Entity;
import model.entity.EntityEffectHandler;

public abstract class Spell implements Spellable{
	protected Entity entity;
	
	public Spell(Entity entity) {
		this.entity = entity;
	}
	
	public boolean able(){
		if (this.entity.getMP() > this.getManaRequirement()) return true;
		else return false;
	}
	
	public final void apply(Entity entityToAffect){
		if (this.able()){
			EntityEffectHandler.subMP(this.entity, this.getManaRequirement());
			this.doTheSpell(entityToAffect);
		}
		//ELSE DO NOTHING
	}
	
	protected abstract void doTheSpell(Entity entityToAffect);
	
	public abstract int getManaRequirement();
	
	public Entity getEntity(){
		return this.entity;
	}
	
	public void makeSoundEffect(){};

}
