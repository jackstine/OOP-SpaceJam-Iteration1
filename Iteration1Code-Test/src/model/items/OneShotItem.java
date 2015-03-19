package model.items;

import model.entity.Avatar;


public abstract class OneShotItem implements Item {
	public abstract boolean action(Avatar avatar);
}
