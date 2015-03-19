package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import model.Game;
import model.World;
import model.entity.Avatar;
import view.CombinedGameView;
import view.ControlConfigView;
import view.SystemMenuView;

public class SystemsController {
	
	private Avatar avatar;
	private World world;
	
	private CombinedGameView combinedGameView;
	private SystemMenuView systemMenu;
    private ControlConfigView controlConfig;
	
	public SystemsController(CombinedGameView combinedGameView, Avatar avatar, World world){
		this.combinedGameView = combinedGameView;
		this.avatar = avatar;
		this.world = world;
		
		systemMenu = new SystemMenuView(new MainMenuButton(),new SaveGameButton(), new BackButtonSysListener(), new OpenControlConfig());
		controlConfig = new ControlConfigView(new BackButtonConfigListener(), new ChangeControlListener(), new ResetControlsListener(), world.getKeySet());
		
    	combinedGameView.addExternalViews(systemMenu);
    	combinedGameView.addExternalViews(controlConfig);
	}
	public void spawnSystems(){
		systemMenu.setVisible(true);
        systemMenu.moveToFront();
    }
	public void spawnControlConfig(){
    	controlConfig.setVisible(true);
        controlConfig.moveToFront();
    }
	
	//Systems
	
	public class OpenControlConfig implements ActionListener { //Systems
        public void actionPerformed(ActionEvent e) {
        	spawnControlConfig();
        	combinedGameView.setNext("Game");
            combinedGameView.setRedraw(true);
        }
    }
    
    public class MainMenuButton implements ActionListener {//Systems
           
            public void actionPerformed(ActionEvent e) {
                combinedGameView.setNext("Main");
                combinedGameView.setRedraw(true);
            }
    }
   
    public class SaveGameButton implements ActionListener {//Systems
           
            public void actionPerformed(ActionEvent e) {
                try {
					new Game(world, avatar).save();
				} catch (IOException e1) {
				}
            }
    }
   
    public class BackButtonSysListener implements ActionListener {//Systems
        public void actionPerformed(ActionEvent e) {
        	combinedGameView.removeExternalView(systemMenu);
            combinedGameView.setNext("Game");
            combinedGameView.setRedraw(true);
        }
    }
    
    //Control Configuration
    
    public class ChangeControlListener implements ActionListener {//ControlConfig
        public void actionPerformed(ActionEvent e) {
        	controlConfig.BindKey();
        }
    }
    
    public class ResetControlsListener implements ActionListener {//ControlConfig
        public void actionPerformed(ActionEvent e) {
        	world.genDefaultKeys();
        	controlConfig.reset();
        }
    }
    
    public class BackButtonConfigListener implements ActionListener {//Systems
        public void actionPerformed(ActionEvent e) {
        	combinedGameView.removeExternalView(controlConfig);
            combinedGameView.setNext("Game");
            combinedGameView.setRedraw(true);
        }
    }
}
