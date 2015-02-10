package model;

import java.util.List;

public class InventoryContainer extends SlotContainer{
	private List<List<Slot>> gridItems;
	
	
	public boolean equipItem(Point point, Item item) {  // What is a Point?
		//equipItem(point, item){
		//this.equip(gridItem[point.x][point.y],Item)
		return true;
	}
	
	public Item unequipItem(Point point) {
		
		return null;
	}
	
	public boolean dropItem(Point point) {
		
		return true;
	}
	
	public boolean swap(Point point1, Point point2) {
		
		return true;
	}
	
	public boolean swap(Point point, Slot slot) {
		
		return true;
	}

	public List<Item> getItems() {
		
		return null;
	}

	@Override
	protected boolean equip(Slot to, Slot from, Item item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected Item unequip(Slot slot) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected boolean drop(Slot slot) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected boolean swap(Slot slot1, Slot slot2) {
		// TODO Auto-generated method stub
		return false;
	}
}
