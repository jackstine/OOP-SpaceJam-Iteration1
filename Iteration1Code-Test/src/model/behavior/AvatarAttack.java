package model.behavior;

import utilities.Directions;
import utilities.HurtSoundEffect;
import utilities.SoundEffect;
import model.GameLog;
import model.entity.Conversable;
import model.entity.Entity;
import model.entity.EntityEffectHandler;

public class AvatarAttack implements Behavior{
	private Entity attacker;
	
	public AvatarAttack(Entity attacker){
		this.attacker = attacker;
	}
	
	public void perform(Entity theAttacked) {
		
		//in a typical engagement scenario, 
		System.out.println("Attacker: "+attacker+"\nDefender: "+theAttacked);
		int oppositeDirection = Directions.getOppositeDirection(attacker.getDirection());
		theAttacked.setDirection(oppositeDirection);
		EntityEffectHandler.applyDamage(theAttacked, Math.max(attacker.attack()-(int)(.2*theAttacked.defense()),0));
		GameLog.writeToLog("Melee Damage Dealt", Math.max(attacker.attack()-(int)(.2*theAttacked.defense()),0) + " damage.");
		SoundEffect effect = new HurtSoundEffect();
	}
	
	public void getBuffs() {}

	public void kill() {
	}
}
