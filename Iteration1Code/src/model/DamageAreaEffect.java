package model;

public class DamageAreaEffect implements AreaEffect{
	
	private double percentDamage;

	//Constructor
	public DamageAreaEffect(double percentDamage){
		this.percentDamage = percentDamage;
	}
	
	public double getPercentDamage() {
		return this.percentDamage;
	}
	
	public void apply(Entity entity) {
		// entity.setStatValue("Life", (int) (entity.getStatValue("Life") * (1-percentDamage)));
		EffectApplication.apply(entity, this);
	}
	
	
}
