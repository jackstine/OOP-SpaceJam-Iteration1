package model;

import java.io.Serializable;

public abstract class InteractiveItem implements Item, Serializable {
	public abstract boolean action(Avatar avatar);
}
