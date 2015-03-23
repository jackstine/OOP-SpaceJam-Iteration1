package model.abilities;

import utilities.DanceSpellSoundEffect;
import utilities.EarthSpellSoundEffect;
import utilities.SoundEffect;
import model.entity.Entity;
import model.entity.EntityEffectHandler;

public class DanceSpell extends EnchantmentSpellSingle  {
private int manaRequired = 2;
	
	public DanceSpell(Entity entity) {
		super(entity);
	}

	@Override
	public void applyEnchantment(Entity entityToAffect) {
		SoundEffect gogo = new DanceSpellSoundEffect();
		EntityEffectHandler.applyDance(entityToAffect);	
	}

	@Override
	public int getManaRequirement() {
		return manaRequired;
	}

}
