package model;

import java.io.Serializable;

public class DeathAreaEffect implements AreaEffect, Serializable{
	
	public void apply(Entity entity){
		EffectApplication.apply(entity, this);
	}
}
