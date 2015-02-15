package model;

import java.io.Serializable;

public class DamageAreaEffect implements AreaEffect, Serializable{
	
	private double percentDamage;

	//Constructor
	public DamageAreaEffect(double percentDamage){
		this.percentDamage = percentDamage;
	}
	
	public double getPercentDamage() {
		return this.percentDamage;
	}
	
	public void apply(Entity entity) {
		EffectApplication.apply(entity, this);
	}
	
	public String toString() {
		return "DamageAreaEffect:" + percentDamage;
	}
	
}
