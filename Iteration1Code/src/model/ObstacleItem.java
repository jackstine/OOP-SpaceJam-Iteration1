package model;

import java.io.Serializable;

public abstract class ObstacleItem implements Item, Serializable {
	public abstract boolean action(Avatar avatar);
}
