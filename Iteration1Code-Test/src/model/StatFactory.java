package model;


import java.util.HashMap;
import java.util.Map;

import view.EquipmentView;
import model.slots.Equipment;

public class StatFactory {
	
	private Map<String,Stat> map;
	private Equipment equipment;
	
	public StatFactory(Equipment equipment){
		this.equipment = equipment;
	}
	
	//DEPRECATED
//	public StatFactory() {}
	
	public final Map<String, Stat> initializeStats() {
		map = createMap();
		createStats();
		return map;
	}
	
	protected Map<String, Stat> createMap() {
		map = new HashMap<String, Stat>();
		return map;
	}
	
	protected void createStats() {
		//INIT PRIMARY STATS
		//the get methods are hooks for overrides by different factories.
		PrimaryStat agility = new Agility(getAgility());
		PrimaryStat experience = new Experience(getExperience());
		PrimaryStat hardiness = new Hardiness(getHardiness());
		PrimaryStat hp = new HP(0);
		PrimaryStat intellect = new Intellect(getIntellect());
		PrimaryStat lives = new Lives(getLivesLeft());
		PrimaryStat movement = new Movement(getMovement());
		PrimaryStat mp = new MP(0);
		PrimaryStat strength = new Strength(getStrength());
		
		
		//INIT DERIVED STATS
		DerivedStat level = new Level();
		DerivedStat life = new Life(hp);
		DerivedStat mana = new Mana(mp);
		OffensiveRating off = new OffensiveRating(equipment.getSlot(EquipmentView.WEAPON_POINT));
		ArmorRating armor = new ArmorRating(equipment.getArmrorSlots());
		DerivedStat def = new DefensiveRating();
		//off.addStat(strength);
		//off.addStat(level);
		//armor.addStat(hardiness);
		
		//Adding references to observers to derive value from.
		experience.addAllObservers(level);
		hardiness.addAllObservers(life, armor);
		intellect.addAllObservers(mana);
		agility.addAllObservers(def);
		strength.addAllObservers(off);
		level.addAllObservers(life, mana, def, off);
		
		//Init derived stat values
		armor.calculateValue();
		def.calculateValue();
		level.calculateValue();
		life.calculateValue();
		mana.calculateValue();
		off.calculateValue();
		
		//INSERT PRIMARY STATS INTO MAP
		map.put("Agility", agility);
		map.put("Experience", experience);
		map.put("Hardiness", hardiness);
		map.put("HP", hp);
		map.put("Intellect", intellect);
		map.put("Lives", lives);
		map.put("Movement", movement);
		map.put("MP", mp);
		map.put("Strength", strength);

		//INSERT DERIVED STATS INTO MAP
		map.put("Level", level);
		map.put("Life", life);
		map.put("Mana", mana);
		map.put("OffensiveRating", off);
		map.put("DefensiveRating", def);
		map.put("ArmorRating", armor);
		equipment.setDerivedStats(armor, off);
	}
	
	protected int getLivesLeft() {
		return 3;
	}
	
	protected int getStrength() {
		return 10;
	}
	
	protected int getAgility() {
		return 10;
	}
	
	protected int getIntellect() {
		return 10;
	}
	
	protected int getHardiness() {
		return 10;
	}
	
	protected int getExperience() {
		return 0;
	}
	
	protected int getMovement() {
		return 10;
	}
	
}
