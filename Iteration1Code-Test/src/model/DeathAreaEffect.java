package model;

import model.Entity.Entity;



public class DeathAreaEffect implements AreaEffect{
	
	public void apply(Entity entity){
		EffectApplication.apply(entity, this);
	}
	
	public String toString() {
		return "DeathAreaEffect";
	}
}
