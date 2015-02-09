package model;

public class Weapon extends TakeableItem implements Equipment {
	private int attack;
	
	
	public Weapon(int attack) {
		
	}
	
	public Weapon(int attack, String image) {
		
	}
	
	public boolean action(Avatar avatar) {
		
		return true;
	}
	
	public int getBonus() {
		
		return 0;
	}
}
