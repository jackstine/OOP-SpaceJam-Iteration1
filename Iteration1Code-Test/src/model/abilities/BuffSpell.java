package model.abilities;

import model.entity.Entity;
import model.entity.EntityEffectHandler;

public class BuffSpell extends BoonSpellSingle {
	private int manaRequired = 0;
	private int mag = 100;
	private String stat = "Movement";
	public BuffSpell(Entity entity) {
		super(entity);
	}
	
	public BuffSpell(Entity entity, int mag, String stat) {
		super(entity);
		this.mag = mag;
		this.stat = stat;
	}

	@Override
	public int getBoon() {
		return mag;
	}

	@Override
	public void applyBoon(Entity entityToAffect) {
		EntityEffectHandler.applyBuff(entityToAffect,stat,mag*this.getEntity().getStatValue("Boon"));	
	}

	@Override
	public int getManaRequirement() {
		return manaRequired;
	}

}
