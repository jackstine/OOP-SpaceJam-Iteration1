package model;

import model.Entity.Entity;


//An interface using another interface is extension, apparently?
//We should look at this.
public interface AreaEffect {
	public void apply(Entity entity);
}
