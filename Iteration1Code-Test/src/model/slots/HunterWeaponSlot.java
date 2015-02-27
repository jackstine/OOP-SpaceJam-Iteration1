package model.slots;

import model.items.Equipable;

public class HunterWeaponSlot extends WeaponSlot{
	
    protected <K extends Equipable> boolean equipItem(K item){
    	if (item.equipWeaponSlot(this)){
    		return super.equipItem(item);
    	}else return false;
    }
}
