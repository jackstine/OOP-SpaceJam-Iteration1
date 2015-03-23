package model.abilities;

import model.entity.Entity;
import model.entity.EntityEffectHandler;

public class BindWound extends Spell{
	private int heal = 50;

	public BindWound(Entity entity) {
		super(entity);
	}

	public boolean able() {
		return true;
	}

	@Override
	protected void doTheSpell(Entity entityToAffect) {
		EntityEffectHandler.applyHeal(entityToAffect, heal);
	}

	@Override
	public int getManaRequirement() {
		return 0;
	}
	

}
