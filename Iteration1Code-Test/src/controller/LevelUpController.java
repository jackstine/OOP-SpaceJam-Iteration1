package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;



import model.Skill;
import model.Entity.Avatar;
import model.occupation.Occupation;
import view.CombinedGameView;
import view.LevelUpView;

public class LevelUpController {
	private Avatar avatar;
	private LevelUpView leveledView;
	private CombinedGameView combinedGameView;
	
	public LevelUpController(CombinedGameView combinedGameView, Avatar avatar){
		this.combinedGameView = combinedGameView;
		this.avatar = avatar;
		this.leveledView = new LevelUpView(genSkillListeners(avatar.getOccupation()));
		
		combinedGameView.addExternalViews(leveledView);
	}
	
	public void spawnLevelUp(){
        if(avatar.getLevels() > 0){
        	leveledView.setVisible(true);
            leveledView.moveToFront();
        }
    }
	
	public Map<String, ActionListener> genSkillListeners(Occupation e){
    	Map<String, ActionListener> skillmap = new HashMap<String, ActionListener>();
			int i = 0;
			String key;
    	for(Entry<String, Skill> entry: e.getSkills().entrySet()){
   			 key = entry.getKey();
   			 skillmap.put(key, new LevelStat(key));
   			 if(i == 4) i = 0;
   		 }
    	return skillmap;        	
    }
	
	public class LevelStat implements ActionListener {
    	String stat = "";
    	String skill = "";
    	String[] stats = {"Strength", "Intellect", "Agility", "Hardiness","Movement"};
    	Random rn = new Random();
    	public LevelStat(String skill){
    		this.skill = skill;        		
    	}
        public void actionPerformed(ActionEvent e) {
        	//avatar.setStatValue(stat, avatar.getStatValue(stat)+1);
        	int i = rn.nextInt(5);
        	String text = "Here are your random stat increases:\n";
        	avatar.setStatValue(stats[i], avatar.getStatValue(stats[i])+1);
        	text += stats[i] + "\n";
        	i = rn.nextInt(5);
        	avatar.setStatValue(stats[i], avatar.getStatValue(stats[i])+1);
        	text += stats[i]+ "\n";
        	i = rn.nextInt(5);
        	avatar.setStatValue(stats[i], avatar.getStatValue(stats[i])+1);
        	text += stats[i]+ "\n";
        	//GameLog.writeToLog(text);
        	avatar.writeJournal(text);
        	
        	avatar.incSkillValue(skill);
        	avatar.setLevels(avatar.getLevels()-1);
        	combinedGameView.removeExternalView(leveledView);
            combinedGameView.setNext("Game");
            combinedGameView.setRedraw(true);
        }
}

}
