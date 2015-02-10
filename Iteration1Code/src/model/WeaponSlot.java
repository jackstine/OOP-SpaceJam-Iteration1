package model;

public class WeaponSlot extends BufferSlot<Weapon>{
	WeaponSlot(OffensiveRating stat){
		addObserver(stat);
	}
	WeaponSlot(){}
	
    public int getBonus(){
    	return this.item.getBonus();
    }

}
