package model.behavior;

import utilities.Directions;
import utilities.HurtSoundEffect;
import utilities.SoundEffect;
import model.GameLog;
import model.entity.Conversable;
import model.entity.Entity;
import model.entity.EntityEffectHandler;

public class Attack implements Behavior{
	private Entity attacker;
	
	public Attack(Entity attacker){
		this.attacker = attacker;
	}
	
	public void perform(Entity theAttacked) {
		
		//in a typical engagement scenario, 
		int oppositeDirection = Directions.getOppositeDirection(theAttacked.getDirection());
		attacker.setDirection(oppositeDirection);
		if(attacker.attack() > theAttacked.defense()) {
			EntityEffectHandler.applyDamage(theAttacked, (attacker.attack()-theAttacked.defense()));
		}
		if(theAttacked.attack() > attacker.defense()) {
			EntityEffectHandler.applyDamage(attacker, (theAttacked.attack()-attacker.defense()));
		}
		System.out.println(theAttacked.attack());
		System.out.println(attacker.attack());
		SoundEffect effect = new HurtSoundEffect();
		GameLog.writeToLog(attacker.getDialogue());
	}
	
	public void getBuffs() {}

	public void kill() {
	}
}
