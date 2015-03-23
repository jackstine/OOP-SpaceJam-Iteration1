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
		EntityEffectHandler.applyDamage(theAttacked, Math.max(attacker.attack()-(int)(.2*theAttacked.defense()),0));
		String log = Math.max(attacker.attack()-(int)(.2*theAttacked.defense()),0) + " damage";
		GameLog.writeToLog("Melee Damage Received", log);
		SoundEffect effect = new HurtSoundEffect();
	}
	
	public void getBuffs() {}

	public void kill() {
	}
}
