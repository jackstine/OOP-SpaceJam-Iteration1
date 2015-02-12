package model;

public class DeathAreaEffect implements AreaEffect{
	
	public void apply(Entity entity){
		EffectApplication.apply(entity, this);
	}
}
