package model.occupation;


import model.EquipmentBuilder;
import model.HunterStatFactory;
import model.StatFactory;
import model.slots.Equipment;
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
	
	protected StatFactory getStatFactory(Equipment equipment){
		return new HunterStatFactory(equipment);
	}
	
	public WeaponSlot makeWeaponSlot(){
		return new HunterWeaponSlot();
	}

	public Equipment createEquipment(EquipmentBuilder eb) {
		return eb.buildBeginerEquipment(this);
	}

//	@Override
//	public Map<String, Stat> createStats() {
//		StatFactory statFactory = new HunterStatFactory();
//		return statFactory.initializeStats();
//	}

}
