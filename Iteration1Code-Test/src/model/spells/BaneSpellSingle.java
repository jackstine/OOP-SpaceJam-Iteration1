package model.spells;

import model.Entity.Entity;
import model.Entity.EntityEffectHandler;

public abstract class BaneSpellSingle extends SpellSingleAffect implements BaneSpell{
	private EntityEffectHandler entityHandler;

	public BaneSpellSingle(Entity entity) {
		super(entity);
		// TODO Auto-generated constructor stub
	}
	
	public void applyDamage(Entity entity){
		entityHandler.applyDamage(entity, this.getDamage());
	}
}
