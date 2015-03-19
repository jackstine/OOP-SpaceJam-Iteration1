package model.spells;

import model.entity.Entity;
import model.entity.EntityEffectHandler;

public abstract class BoonSpellSingle extends SpellSingleAffect implements BoonSpell{

	public BoonSpellSingle(Entity entity) {
		super(entity);
	}
	
	public boolean able(){
		if (this.entity.getMP() > this.getManaRequirement()) return true;
		else return false;
	}
	
	public void apply(Entity entityToAffect){
		if (this.able()){
			EntityEffectHandler.subMP(this.entity, this.getManaRequirement());
			this.applyBoon(entityToAffect);
		}
		//ELSE DO NOTHING
	}

	public abstract void applyBoon(Entity entityToAffect);
}
