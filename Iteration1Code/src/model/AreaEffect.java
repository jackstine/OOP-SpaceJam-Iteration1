package model;

import java.io.Serializable;

//An interface using another interface is extension, apparently?
//We should look at this.
public interface AreaEffect {//implements Serializable{
	public void apply(Entity entity);
}
