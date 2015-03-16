package model.spells;

import model.Entity.Entity;
import model.Entity.EntityEffectHandler;

public abstract class BaneSpellSingle extends SpellSingleAffect implements BaneSpell{

	public BaneSpellSingle(Entity entity) {
		super(entity);
	}
	
	public final void apply(Entity entityToAffect){
		if (this.able()){
			EntityEffectHandler.consumeMana(this.entity, this.getManaRequirement());
			this.applyDamage(entityToAffect);
		}
		//ELSE DO NOTHING
	}
	
	public void applyDamage(Entity entity){
		EntityEffectHandler.applyDamage(entity, this.getDamage());
	}
}
