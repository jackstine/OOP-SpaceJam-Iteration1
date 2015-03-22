package model.entity;

import java.awt.image.BufferedImage;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import model.items.TakeableItem;
import model.occupation.Occupation;
import utilities.*;

public class Avatar extends Entity {
	private int levels = 0;
	private ArrayList<String> journal = new ArrayList<String>();
	private boolean writing = false;
	private String currMap = "Main";
	private final static String[] primaryStats = {"Agility", "Experience", "Hardiness",
											"HP", "Intellect", "Lives", "MP",
											"Movement", "Strength"};
	
	public Avatar(Occupation occupation) {
		super(occupation);
		gold = 200;
	}
	
	// used for writing to the save file
	// name, occupation, stats, direction, inventory, equipment
	public String toString() {
		String result = "";
		result += "Avatar:" + this.name;
		result += "\n" + this.occupation;
		for (String key : primaryStats) result += "\n" + this.stats.getString(key);
		result += "\nDirection:" + this.direction;
		result += "\n" + this.inventoryEquipment.getInventory();
		result += "\n" + this.inventoryEquipment.getEquipment();
		result += "\nLevels:" + this.levels;
		result += "\nCurrentMap:" + this.currMap;
		return result;
	}

	public int getLevels() {
		return levels;
	}

	public void setLevels(int levels) {
		this.levels = levels;
	}
	
	public void writeJournal(String s){
		DateFormat df = new SimpleDateFormat("HH:mm:ss");
		Date today = Calendar.getInstance().getTime(); 
		String reportDate = df.format(today);
		s = reportDate + ": \n--------------------------------------------\n" + s;
		s += "\n--------------------------------------------\n";
		if(journal.size() > 20){
			journal.remove(0);
		}
		journal.add(s);
		writing = true;
	} 
	public void doneWriting(){
		writing = false;
	}
	public boolean isWriting(){
		return writing;
	}
	public String getJournal(){
		String j = "";
		for(int i = 0; i < journal.size(); ++i){
			j += journal.get(i);
		}
		writing = false;
		return j;
	}

	public String getCurrMap() {
		return currMap;
	}

	public void setCurrMap(String currMap) {
		this.currMap = currMap;
	}
	
	public void makeDeathSoundEffect(){
		soundEffect = new FriendlyDeathSoundEffect();
	}	
}