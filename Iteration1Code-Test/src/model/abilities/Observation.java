package model.abilities;

import model.entity.Entity;

public class Observation extends Spell{

	public Observation(Entity entity) {
		super(entity);
	}

	@Override
	protected void doTheSpell(Entity entityToAffect) {
		this.entity.setObservation();
	}

	@Override
	public int getManaRequirement() {
		return 0;
	}

}
