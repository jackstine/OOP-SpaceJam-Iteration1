package model.occupation;

import java.util.Map;

import model.AlchemistStatFactory;
import model.Stat;
import model.StatFactory;
import model.slots.WeaponSlot;
import model.slots.AlchemistWeaponSlot;

public class Alchemist extends Occupation{
	
	public Alchemist() {
		portraitLocation = "src/res/img/alchemist_portrait.jpg";
		name = "Alchemist";
	}
	
	public void attack() {
		// TODO Auto-generated method stub
		
	}

	public void useAbiltiy() {
		// TODO Auto-generated method stub
	
	}
	
	public WeaponSlot makeWeaponSlot(){
		return new AlchemistWeaponSlot();
	}

	@Override
	public Map<String, Stat> createStats() {
		StatFactory statFactory = new AlchemistStatFactory();
		return statFactory.initializeStats();
	}
}
