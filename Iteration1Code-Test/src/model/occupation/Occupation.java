package model.occupation;

import java.util.Map;

import model.Stat;
import model.slots.WeaponSlot;

public abstract class Occupation{
	
	protected String portraitLocation;
	protected String name;
	
	public abstract void attack();
	public abstract void useAbiltiy();
	public abstract Map<String, Stat> createStats();
	
	public String getPortraitLocation() {
			return portraitLocation;
	}
	
	public abstract WeaponSlot makeWeaponSlot();
	
	public String getName() {
		return name;
	}
	
	public String toString() {
		return "Occupation:" + this.name;
	}
}
