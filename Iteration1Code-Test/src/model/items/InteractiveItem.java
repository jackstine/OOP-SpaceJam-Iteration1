package model.items;

import model.entity.Avatar;

public abstract class InteractiveItem implements Item {
	protected String ITEM_NAME;
	public abstract boolean action(Avatar avatar);
}
