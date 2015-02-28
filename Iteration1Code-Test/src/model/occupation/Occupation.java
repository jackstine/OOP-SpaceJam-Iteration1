package model.occupation;

import java.util.Map;

import model.Stat;
import model.StatFactory;
import model.slots.Equipment;
import model.slots.WeaponSlot;

public abstract class Occupation{
	
	protected String portraitLocation;
	protected String name;
	protected Equipment equipment;
	protected Map<String,Stat> stats;
	
	public abstract void attack();
	public abstract void useAbiltiy();
	
	public Map<String,Stat> getStats(){
		return this.stats;
	}
	
	public Equipment getEquipment(){
		return this.equipment;
	}
	
	public void createNecessities(){
		Equipment equipment = new Equipment(this.makeWeaponSlot());
		StatFactory statFactory = this.getStatFactory(equipment);
		this.stats = statFactory.initializeStats();
	}
	
	protected abstract StatFactory getStatFactory(Equipment equipment);
	public abstract WeaponSlot makeWeaponSlot();
	
	//DEPRECATED
//	public abstract Map<String, Stat> createStats();	
//	public abstract WeaponSlot linkEquipment();
	
	public String getPortraitLocation() {
			return portraitLocation;
	}
	
	public String getName() {
		return name;
	}
	
	public String toString() {
		return "Occupation:" + this.name;
	}
}
