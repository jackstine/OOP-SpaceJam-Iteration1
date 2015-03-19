package model;

import model.Entity.Entity;



public class DamageAreaEffect implements AreaEffect{
	
	private double percentDamage;

	//Constructor
	public DamageAreaEffect(double percentDamage){
		this.percentDamage = percentDamage;
	}
	
	public double getPercentDamage() {
		return this.percentDamage;
	}
	
	public void setPercentDamage(double percentDamage) {
		this.percentDamage = percentDamage;
	}
	public void apply(Entity entity) {
		EffectApplication.apply(entity, this);
	}
	
	public String toString() {
		return "DamageAreaEffect:" + percentDamage;
	}
	
}
