package model;

public abstract class SlotContainer {
	protected abstract boolean equip(Slot to, Slot from, Item item);
	protected abstract Item unequip(Slot slot);
	protected abstract boolean drop(Slot slot);
	protected abstract boolean swap(Slot slot1, Slot slot2);
}
