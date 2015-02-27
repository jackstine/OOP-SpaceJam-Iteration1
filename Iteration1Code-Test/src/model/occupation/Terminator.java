package model.occupation;

import java.util.Map;

import model.Stat;
import model.StatFactory;
import model.TerminatorStatFactory;
import model.slots.TerminatorWeaponSlot;
import model.slots.WeaponSlot;

public class Terminator extends Occupation{

	public Terminator() {
		portraitLocation = "src/res/img/terminator_portrait.jpg";
		name = "Terminator";
	}
	
	public void attack() {
		// TODO Auto-generated method stub
		
	}

	public void useAbiltiy() {
		// TODO Auto-generated method stub
		
	}
	
	public WeaponSlot makeWeaponSlot(){
		return new TerminatorWeaponSlot();
	}

	@Override
	public Map<String, Stat> createStats() {
		StatFactory statFactory = new TerminatorStatFactory();
		return statFactory.initializeStats();
	}
}
