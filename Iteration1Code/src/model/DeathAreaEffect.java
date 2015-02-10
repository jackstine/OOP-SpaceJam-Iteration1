package model;

public class DeathAreaEffect implements AreaEffect{
	public void apply(Entity entity){
		entity.setLives(entity.getLives() - 1);
	}
}
