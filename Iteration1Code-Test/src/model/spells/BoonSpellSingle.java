package model.spells;

import model.entity.Entity;

public abstract class BoonSpellSingle extends SpellSingleAffect implements BoonSpell{

	public BoonSpellSingle(Entity entity) {
		super(entity);
	}
	protected void doTheSpell(Entity entityToAffect) {
		applyBoon(entityToAffect);
	}
	public abstract void applyBoon(Entity entityToAffect);

}
