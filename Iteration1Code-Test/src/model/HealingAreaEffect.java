package model;

import model.Entity.Entity;


public class HealingAreaEffect implements AreaEffect{
	
	private double percentHealth;
	
	public HealingAreaEffect(double percentHealth){
		this.percentHealth = percentHealth;
	}
	
	public double getPercentHealth() {
		return this.percentHealth;
	}
	
	public void apply(Entity entity) {
		EffectApplication.apply(entity, this);		
	}

}
