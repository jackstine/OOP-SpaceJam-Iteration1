package model.entity;

import java.awt.Component;
import java.awt.image.BufferedImage;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import model.GameMap;
import model.Point;
import model.behavior.AvatarAttack;
import model.behavior.BehaviorComposite;
import model.behavior.State;
import model.items.TakeableItem;
import model.occupation.Occupation;
import utilities.*;
import view.AbilityView;

public class Avatar extends Entity {
	private int levels = 0;
	private ArrayList<String> journal = new ArrayList<String>();
	private State engagedState;
	private boolean writing = false;
	private String currMap = "Main";
	private final static String[] primaryStats = {"Agility", "Experience", "Hardiness",
											"HP", "Intellect", "Lives", "MP",
											"Movement", "Strength"};
	
	public Avatar(Occupation occupation) {
		super(occupation);
		gold = 200;
		engagedState = new State();
		engagedState.setState(new BehaviorComposite(new AvatarAttack(this)));
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
	
	public void attemptAttack(GameMap currMap, Point point) {
		if(currMap.getTileEntity(point) != null) {
			engagedState.perform(currMap.getTileEntity(point));
		}
		else {
			SwooshSoundEffect swoosh = new SwooshSoundEffect();
		}
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
	
	@Override
	public void makeDeathSoundEffect(){
		if(this.stats.getStatValue("Lives") >= 1){
				soundEffect = new FriendlyDeathSoundEffect();
		}
		else
			soundEffect = new LastDeathSoundEffect();
	}
	/*
	//may not need to override
	 */
	
	/*
	//private void useAbility() {
	//	
	//}
	//may not need to override
	 */
}