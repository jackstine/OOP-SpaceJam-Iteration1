package model.abilities;

import model.entity.Entity;
import model.entity.EntityEffectHandler;

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
		EntityEffectHandler.applyHeal(entityToAffect, this.heal*this.getEntity().getSkillValue("Boon"));
	}
	
	public int getManaRequirement() {
		return this.manaRequired;
	}

}
