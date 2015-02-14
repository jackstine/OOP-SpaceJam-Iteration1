package view;

import java.awt.*;
import java.awt.event.*;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.util.*;

import model.*;

/*

StatusView Class
Displays player portrait, all relevant stats, and the character/system menu buttons

*/

public class StatusView extends JPanel {
	
	private Avatar avatar;
	private JPanel statusInfo;
	
	private PortraitView portraitView;
	
	private JLabel avatarName;
	private JLabel avatarLevel;
	private JLabel avatarOccupation;
	
	private JLabel avatarLife;
	private JLabel avatarMana;
	
	private JPanel levelClassPanel;
	//private JPanel buttonPanel;
	private JPanel vitalsPanel;
	//private JButton systemMenu;
	//private JButton characterMenu;
	
	private JPanel abilitiesPanel;
	private JLabel abilitiesLabel;
	private ArrayList<JButton> abilityButtons;
	
	private JPanel portraitStatsPanel;
	
	private BufferedImage avatarPortrait;
	
	public StatusView(Avatar a) {
		
		avatar = a;
		
		System.out.println(avatar.getOccupation().getPortraitLocation());
		
        try {
        	
	        avatarPortrait = ImageIO.read(new File(avatar.getOccupation().getPortraitLocation()));
        } catch (Exception e) {
        	System.out.println("Avatar portrait image not found!");
        }
        
		setLayout(new BorderLayout());
		statusInfo = new JPanel();
		
		/*buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(2,1));
		systemMenu = new JButton("System");
		characterMenu = new JButton("Character");*/
		
		vitalsPanel = new JPanel();
		avatarName = new JLabel(avatar.getName());
		
		avatarOccupation = new JLabel(avatar.getOccupation().getName());
		avatarLevel = new JLabel("Lv. "+avatar.getStatValue("Level"));
		
		//TODO
		//figure out where player max hp and current hp is stored
		//same for mana, let's get this up and running
		avatarLife = new JLabel("HP: "+avatar.getStatValue("HP")+"/"+avatar.getStatValue("Life")); 
		avatarMana = new JLabel("Mana: "+avatar.getStatValue("MP")+"/"+avatar.getStatValue("Mana"));
		
		levelClassPanel = new JPanel();
		
		levelClassPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		levelClassPanel.add(avatarLevel);
		levelClassPanel.add(avatarOccupation);
		
		vitalsPanel.setLayout(new BoxLayout(vitalsPanel, BoxLayout.Y_AXIS));
		vitalsPanel.add(avatarName);
		vitalsPanel.add(levelClassPanel);
		vitalsPanel.add(avatarLife);
		vitalsPanel.add(avatarMana);
		
		portraitView = new PortraitView(avatarPortrait);
		portraitView.setPreferredSize(new Dimension(210, 168));
		portraitView.repaint();
		
		portraitStatsPanel = new JPanel();
		portraitStatsPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		portraitStatsPanel.add(portraitView);
		portraitStatsPanel.add(vitalsPanel);
		
		abilitiesPanel = new JPanel();
		abilitiesLabel = new JLabel("Ability Select");
		
		abilitiesPanel.setLayout(new BoxLayout(abilitiesPanel, BoxLayout.Y_AXIS));
		abilitiesPanel.add(abilitiesLabel);
		
		abilityButtons = new ArrayList<JButton>();
		
		//TODO
		/*When abilities are implemented, we want to iterate through the avatar's abilities
		 * here, generate a corresponding JButton and add it to the ArrayList as well as the
		 * abilitiesPanel. If this is not the best solution due to controller issues, we can
		 * discuss other options. */
		//For now, default buttons
		for(int i = 1; i < 5; i++) {
			abilityButtons.add(new JButton("Ability "+i));
			abilitiesPanel.add(abilityButtons.get(abilityButtons.size()-1));
		}
		
		statusInfo.setLayout(new GridLayout(1,2));
		
		statusInfo.add(portraitStatsPanel);
		statusInfo.add(abilitiesPanel);
		
		add(statusInfo, BorderLayout.CENTER);
	}

	public StatusView() {
		// TODO Auto-generated constructor stub
	}

	//TODO
	//will render relevant avatar stats to the statusInfo JPanel
	public void displayAvatarStats() {
	}
	
	//TODO
	//will render relevant avatar picture to the statusInfo JPanel
	//note: where is this image stored?
	public void displayAvatarPortrait() {
	}
}