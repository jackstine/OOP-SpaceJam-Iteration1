package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Entity.Avatar;
import view.CombinedGameView;
import view.StatisticsView;

public class StatsController {
	private CombinedGameView combinedGameView;
	private StatisticsView statsView;
	private Avatar avatar;
	
	public StatsController(CombinedGameView combinedGameView, Avatar avatar){
		this.combinedGameView = combinedGameView;
		this.avatar = avatar;
		statsView = new StatisticsView(avatar, new RetGameStatsButton());
		
		combinedGameView.addExternalViews(statsView);
	}
	
	public void spawnStats(){
		 statsView.setVisible(true);
	     statsView.moveToFront();
	 }
	
	public void updatetable(){
		statsView.updatetable(avatar);
	}
	
	public class RetGameStatsButton implements ActionListener {//Statistics
        
        public void actionPerformed(ActionEvent e) {
        	combinedGameView.removeExternalView(statsView);
            combinedGameView.setNext("Game");
            combinedGameView.setRedraw(true);
        }
	}
}
