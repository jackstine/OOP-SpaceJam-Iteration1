package model.abilities;

import utilities.EarthSpellSoundEffect;
import utilities.ObserveSoundEffect;
import utilities.SoundEffect;
import model.entity.Entity;

public class Observation extends Spell{

	public Observation(Entity entity) {
		super(entity);
	}

	@Override
	protected void doTheSpell(Entity entityToAffect) {
		SoundEffect gogo = new ObserveSoundEffect();
		this.entity.setObservation();
	}

	@Override
	public int getManaRequirement() {
		return 0;
	}

}
