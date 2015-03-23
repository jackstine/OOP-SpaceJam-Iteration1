package model.entity;

import model.GameLog;
import utilities.HurtSoundEffect;
import utilities.SoundEffect;

public class EntityEffectHandler {
	
	
	public static void applyDamage(Entity entity,int damage){
		entity.subHP(damage);
	}
	
	public static void applyHeal(Entity entity, int heal){
		entity.addHP(heal);
	}
	
	public static void applyBuff(Entity entity, String stat, int mag){
		entity.tempIncStat(stat,mag);
	}
	
	public static void applyPolymorph(Entity entity){
		entity.polymorph();
	}

	
	public static void subMP(Entity entity, int mana){entity.subMP(mana);}
	public static void addMP(Entity entity,int mana){entity.addMP(mana);}
	public static void stealth(final Entity entity) {
		new Thread(new Runnable() {

			@Override
			public void run() {
				entity.makeTransformedSpriteArray();
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				entity.restoreSpriteArray();
			}
			
		}).start();
	}
}
