package model.stats;

import java.util.Map;

public class EntityStats {
	// this class is a association class to the stats
	private Map<String,Stat> stats;
	
	public EntityStats(Map<String,Stat> stats){
		this.stats = stats;
	}
	
	public String getStat(String s){
		return Integer.toString(stats.get(s).getValue());
	}
	
	public String getString(String key){
		return stats.get(key).toString();
	}
	
	public void setStatValue(String key, int value) {
		if (this.stats.containsKey(key)) this.stats.get(key).setValue(value);
	}
	
	public int getStatValue(String key) {
		if (this.stats.containsKey(key)) return this.stats.get(key).getValue();
		return -1;
	}
	
	private int getSV(String stat){
		return this.stats.get(stat).getValue();
	}
	
	private void subSV(String stat,int change){
		int valueLeft = this.getSV(stat) - change;
		this.stats.get(stat).setValue(valueLeft);
	}
	
	private void addSV(String stat,int change){
		int valueLeft = this.getSV(stat) + change;
		this.stats.get(stat).setValue(valueLeft);
	}
	
	public int getAgility(){return this.getSV("Agility");}
	public int getExperience(){return this.getSV("Experience");}
	public int getHardiness(){return this.getSV("Hardiness");}
	public int getHP(){return this.getSV("HP");}
	public int getIntellect(){return this.getSV("Intellect");}
	public int getLives(){return this.getSV("Lives");}
	public int getMovement(){return this.getSV("Movement");}
	public int getMP(){return this.getSV("MP");}
	public int getLevel(){return this.getSV("Level");}
	public int getStrength(){return this.getSV("Strength");}
	public int getLife(){return this.getSV("Life");}
	public int getMana(){return this.getSV("Mana");}
	public int getOffensiveRating(){return this.getSV("OffensiveRating");}
	public int getDefensiveRating(){return this.getSV("DefensiveRating");}
	public int getArmorRating(){return this.getSV("ArmorRating");}
	
	public void subHP(int change){this.subSV("HP", change);}
	public void subMP(int change){this.subSV("MP", change);}
	
	public void addHP(int change){this.addSV("HP", change);}
	public void addMP(int change){this.addSV("MP", change);}
}
