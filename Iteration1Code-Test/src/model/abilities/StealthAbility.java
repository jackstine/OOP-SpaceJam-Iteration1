package model.abilities;

import model.entity.Entity;
import model.entity.EntityEffectHandler;

public class StealthAbility extends BoonSpellSingle {

	public StealthAbility(Entity entity) {
		super(entity);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getBoon() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void applyBoon(Entity entityToAffect) {
		// TODO Auto-generated method stub
		EntityEffectHandler.stealth(entityToAffect);
	}

	@Override
	public int getManaRequirement() {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
