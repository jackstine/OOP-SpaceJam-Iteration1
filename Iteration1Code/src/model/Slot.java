package model;

public interface Slot {
	public boolean hasItem(Item item);
	public boolean equipItem(Item item);
	public Item unequipItem();
}
