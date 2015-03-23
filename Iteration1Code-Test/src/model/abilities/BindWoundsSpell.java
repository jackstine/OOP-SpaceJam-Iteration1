package model.abilities;

import utilities.EarthSpellSoundEffect;
import utilities.SoundEffect;
import model.entity.Entity;
import model.entity.EntityEffectHandler;

public class BindWoundsSpell extends BoonSpellSingle{
	private int manaRequirement = 10;
	private int heal = 10;
	
	public BindWoundsSpell(Entity entity) {
		super(entity);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getBoon() {
		return this.heal;
	}

	@Override
	public void applyBoon(Entity entityToAffect) {
		//SoundEffect gogo = new BindWoundsSoundEffect();
		EntityEffectHandler.applyHeal(entityToAffect, this.heal*this.getEntity().getSkillValue("Boon"));
	}

	@Override
	public int getManaRequirement() {
		return this.manaRequirement;
	}

}
