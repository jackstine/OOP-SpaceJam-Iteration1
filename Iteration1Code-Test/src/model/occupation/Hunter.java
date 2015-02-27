package model.occupation;


import java.util.Map;

import model.HunterStatFactory;
import model.Stat;
import model.StatFactory;
import model.slots.HunterWeaponSlot;
import model.slots.WeaponSlot;

public class Hunter extends Occupation{

	public Hunter() {
		portraitLocation = "src/res/img/hunter_portrait.jpg";
		name = "Hunter";
	}
	
	public void attack() {
		// TODO Auto-generated method stub
		
	}

	public void useAbiltiy() {
		// TODO Auto-generated method stub
		
	}
	public WeaponSlot makeWeaponSlot(){
		return new HunterWeaponSlot();
	}

	@Override
	public Map<String, Stat> createStats() {
		StatFactory statFactory = new HunterStatFactory();
		return statFactory.initializeStats();
	}

}
