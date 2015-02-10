package model;

public class Armor extends TakeableItem implements Equipable {
	private int armor;
	
	public Armor(){}
	
	public Armor(int armor) {
		this.armor = armor;
	}
	
	//TODO thought we were going to put images in a MAP??
	public Armor(int armor, String image) {
		
	}
	
	public boolean action(Avatar avatar) {
		
		return true;
	}
	
	public int getBonus() {
		
		return 0;
	}
}
