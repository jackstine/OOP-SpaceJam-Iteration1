package model.items;

import model.Entity.Avatar;


public abstract class OneShotItem implements Item {
	public abstract boolean action(Avatar avatar);
}
