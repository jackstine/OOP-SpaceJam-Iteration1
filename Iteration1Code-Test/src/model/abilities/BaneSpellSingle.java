package model.abilities;

import model.GameLog;
import model.entity.Entity;
import model.entity.EntityEffectHandler;

public abstract class BaneSpellSingle extends SpellSingleAffect implements BaneSpell{

	public BaneSpellSingle(Entity entity) {
		super(entity);
	}
	
	protected final void doTheSpell(Entity entityToAffect) {
		int damage=this.getDamage()*this.getEntity().getSkillValue("Bane");
		EntityEffectHandler.applyDamage(entityToAffect, this.getDamage()*this.getEntity().getSkillValue("Bane"));
		GameLog.writeToLog("Spell Damage", "You have dealt " + damage + " damage.");
		//System.out.println("Damage scaling: " + this.getDamage()*this.getEntity().getSkillValue("Bane"));
		makeSoundEffect();
	}
}
