package model.abilities;

import model.entity.Entity;

public class Observation extends Spell{

	public Observation(Entity entity) {
		super(entity);
	}

	@Override
	protected void doTheSpell(Entity entityToAffect) {
	}

	@Override
	public int getManaRequirement() {
		return 0;
	}

}
