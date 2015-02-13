package model;

import java.io.Serializable;

public abstract class OneShotItem implements Item, Serializable {
	public abstract boolean action(Avatar avatar);
}
