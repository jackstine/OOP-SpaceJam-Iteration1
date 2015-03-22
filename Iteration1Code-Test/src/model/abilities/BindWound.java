package model.abilities;

import model.entity.Entity;

public class BindWound extends Spell{

	public BindWound(Entity entity) {
		super(entity);
	}

	public boolean able() {
		return false;
	}

	@Override
	protected void doTheSpell(Entity entityToAffect) {
	}

	@Override
	public int getManaRequirement() {
		return 0;
	}
	

}
