package model.abilities;

import model.entity.Entity;

public abstract class EnchantmentSpellSingle extends SpellSingleAffect implements EnchantmentSpell {
	public EnchantmentSpellSingle(Entity entity) {
		super(entity);
	}
	protected void doTheSpell(Entity entityToAffect) {
		applyEnchantment(entityToAffect);
	}
	public abstract void applyEnchantment(Entity entityToAffect);

}
