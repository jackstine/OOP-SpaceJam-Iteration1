package model.behavior;

import utilities.Directions;
import utilities.HurtSoundEffect;
import utilities.SoundEffect;
import model.entity.Entity;
import model.entity.EntityEffectHandler;

public class Attack implements Behavior{
	private Entity entity;
	
	public Attack(Entity entity){
		this.entity = entity;
	}
	
	public void perform(Entity attacker,Entity theAttacked) {
		int oppositeDirection = Directions.getOppositeDirection(theAttacked.getDirection());
		attacker.setDirection(oppositeDirection);
		if(attacker.attack() > theAttacked.defense()) {
			EntityEffectHandler.applyDamage(theAttacked, (attacker.attack()-theAttacked.defense()));
		}
		if(theAttacked.attack() > attacker.defense()) {
			EntityEffectHandler.applyDamage(theAttacked, (theAttacked.attack()-attacker.defense()));
		}
		SoundEffect effect = new HurtSoundEffect();
	}

	public void getBuffs() {}
}
