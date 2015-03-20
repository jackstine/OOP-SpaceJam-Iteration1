package model.behavior;

import utilities.Directions;
import model.entity.Entity;
import model.entity.EntityEffectHandler;

public class Attack implements Behavior{
	
	public Attack(){}
	
	public void perform(Entity attacker,Entity theAttacked) {
		EntityEffectHandler.applyDamage(theAttacked, attacker.attack());
		int oppositeDirection = Directions.getOppositeDirection(theAttacked.getDirection());
		attacker.setDirection(oppositeDirection);
	}

	public void getBuffs() {}
}
