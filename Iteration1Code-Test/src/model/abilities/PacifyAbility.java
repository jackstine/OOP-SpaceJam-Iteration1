package model.abilities;

import model.GameLog;
import model.entity.Entity;
import model.entity.EntityEffectHandler;

public class PacifyAbility extends EnchantmentSpellSingle{

	public PacifyAbility(Entity entity) {
		super(entity);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void applyEnchantment(Entity entityToAffect) {
		GameLog.writeToLog("Pacify", "Go to sleep...");
		EntityEffectHandler.pacify(entityToAffect);	
		
	}

	@Override
	public int getManaRequirement() {
		// TODO Auto-generated method stub
		return 5;
	}

}
