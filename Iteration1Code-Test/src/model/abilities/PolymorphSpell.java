package model.abilities;

import model.entity.Entity;
import model.entity.EntityEffectHandler;

public class PolymorphSpell extends EnchantmentSpellSingle {

	private int manaRequired = 2;
	
	public PolymorphSpell(Entity entity) {
		super(entity);
	}

	@Override
	public void applyEnchantment(Entity entityToAffect) {
		EntityEffectHandler.applyPolymorph(entityToAffect);	
	}

	@Override
	public int getManaRequirement() {
		return manaRequired;
	}

}