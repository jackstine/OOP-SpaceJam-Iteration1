package model;

public class HealingAreaEffect implements AreaEffect{
	private double percentHealth;
	
	HealingAreaEffect(double percentHeal){
		percentHealth = percentHeal;
	}
	
	public void apply(Entity entity) {
		entity.setHealth(entity.getHealth() * (1+percentHealth));
		
	}

}
