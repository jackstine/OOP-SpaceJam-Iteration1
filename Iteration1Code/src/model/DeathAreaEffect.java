package model;

public class DeathAreaEffect implements AreaEffect{
	public void apply(Entity entity){
		entity.setStatValue("Lives", entity.getStatValue("Lives") - 1);
	}
}
