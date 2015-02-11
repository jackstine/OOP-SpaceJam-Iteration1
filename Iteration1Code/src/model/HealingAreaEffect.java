package model;

public class HealingAreaEffect implements AreaEffect{
	private double percentHealth;
	
	HealingAreaEffect(double percentHeal){
		percentHealth = percentHeal;
	}
	
	public void apply(Entity entity) {
		entity.setStatValue("Life", (int) (entity.getStatValue("Life") * (1+percentHealth)));
		
	}

}
