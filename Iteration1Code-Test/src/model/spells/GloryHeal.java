package model.spells;

import model.Entity.Entity;
import model.Entity.EntityEffectHandler;

public class GloryHeal extends BoonSpellSingle{
	private int manaRequired = 10;
	private int heal = 10;

	public GloryHeal(Entity entity) {
		super(entity);
	}
	
	public int getBoon() {
		return this.heal;
	}

	public void applyBoon(Entity entityToAffect) {
		EntityEffectHandler.applyHeal(entityToAffect, this.heal);
	}
	
	public int getManaRequirement() {
		return this.manaRequired;
	}

}
