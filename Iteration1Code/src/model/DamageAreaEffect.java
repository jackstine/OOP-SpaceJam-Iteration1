package model;

public class DamageAreaEffect implements AreaEffect{
	private double percentDamage;

	//Constructor
	DamageAreaEffect(double percentDmg){
		percentDamage = percentDmg;
	}
	
	public void apply(Entity entity) {
		entity.setHealth(entity.getHealth() * (1-percentDamage));
	}
	
	
}