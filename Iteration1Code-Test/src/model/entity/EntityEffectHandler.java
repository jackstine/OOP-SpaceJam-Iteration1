package model.entity;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import model.GameMap;
import model.World;
import model.behavior.IdleBehavior;

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
				GameMap currMap = World.getMap(entity.getCurrMap());
				Set<Entity> entities = currMap.getEntities();
				HashMap<Entity,Integer> oldEntities = new HashMap<Entity,Integer>();
				for(Entity e : entities) {
					oldEntities.put(e,e.getStatValue("Sight"));
					e.setStatValue("Sight", 0);
				}
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for(Entity e : oldEntities.keySet()) {
					e.setStatValue("Sight", oldEntities.get(e));
				}
				entity.restoreSpriteArray();
			}
			
		}).start();
	}
	public static void pacify(final Entity e) {
		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		}).start();
			
	}

}
