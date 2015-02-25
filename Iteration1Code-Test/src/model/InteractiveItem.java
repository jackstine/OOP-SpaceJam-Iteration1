package model;

public abstract class InteractiveItem implements Item {
	protected String ITEM_NAME;
	public abstract boolean action(Avatar avatar);
}
