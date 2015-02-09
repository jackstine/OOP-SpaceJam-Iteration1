package model;

public class Armor extends TakeableItem implements Equipment {
	private int armor;
	
	
	public Armor(int armor) {
		
	}
	
	public Armor(int armor, String image) {
		
	}
	
	public boolean action(Avatar avatar) {
		
		return true;
	}
	
	public int getBonus() {
		
		return 0;
	}
}
