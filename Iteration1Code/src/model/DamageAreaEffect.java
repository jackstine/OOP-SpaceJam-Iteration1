package model;

public class DamageAreaEffect implements AreaEffect{
	private double percentDamage;

	//Constructor
	DamageAreaEffect(double percentDmg){
		percentDamage = percentDmg;
	}
	
	public void apply(Entity entity) {
		entity.setLife(entity.getStatValue("Life") * (1-percentDamage));
	}
	
	
}
