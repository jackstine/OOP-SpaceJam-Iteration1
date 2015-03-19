package model.items;

import model.Entity.Avatar;

public abstract class InteractiveItem implements Item {
	protected String ITEM_NAME;
	public abstract boolean action(Avatar avatar);
}
