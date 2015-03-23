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
		System.out.println("Attacker: "+attacker+"\nDefender: "+theAttacked);
		int oppositeDirection = Directions.getOppositeDirection(theAttacked.getDirection());
		attacker.setDirection(oppositeDirection);
		EntityEffectHandler.applyDamage(theAttacked, Math.max(attacker.attack()-(int)(.2*theAttacked.defense()),0));
		String log = "You have dealt " + theAttacked.attack() + " damage";
		log += "\nYou have received " + attacker.attack() + " damage";
		GameLog.writeToLog("Melee Damage", log);
		SoundEffect effect = new HurtSoundEffect();
		GameLog.writeToLog("Dialogue", attacker.getDialogue());
	}
	
	public void getBuffs() {}

	public void kill() {
	}
}
