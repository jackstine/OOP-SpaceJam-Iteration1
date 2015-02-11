package model;

public class HealingAreaEffect implements AreaEffect{
	
	private double percentHealth;
	
	HealingAreaEffect(double percentHealth){
		this.percentHealth = percentHealth;
	}
	
	public double getPercentHealth() {
		return this.percentHealth;
	}
	
	public void apply(Entity entity) {
		//entity.setStatValue("Life", (int) (entity.getStatValue("Life") * (1+percentHealth)));
		EffectApplication.apply(entity, this);
	}

}
