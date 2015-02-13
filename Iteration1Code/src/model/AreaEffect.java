package model;

import java.io.Serializable;

public interface AreaEffect implements Serializable{
	public void apply(Entity entity);
}
