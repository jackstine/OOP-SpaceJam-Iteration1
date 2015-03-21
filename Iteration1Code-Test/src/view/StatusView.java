package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import utilities.FontHandler;


import model.GameLog;
import model.entity.Avatar;

/*

StatusView Class
Displays player portrait, all relevant stats, and the character/system menu buttons

*/

@SuppressWarnings("serial")
public class StatusView extends JPanel {
	
	private Avatar avatar;
	//private Occupation occ = avatar.getOccupation();
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
	
	private FontHandler fh = new FontHandler();
	private Font labelFont;
	
	private JTextArea terminal = new JTextArea();
	
	JProgressBar health;
	JProgressBar mana;
	JProgressBar lives;
	JLabel avatarInfo;
	
	public StatusView(Avatar a) {
		
		avatar = a;
		labelFont = fh.AfterDisasterFont();
		
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
		avatarInfo = new JLabel("<html>" + avatar.getOccupation().getName() + " " + avatar.getName() + "<br>Lv." + avatar.getStatValue("Level") +" Level Ups: " + avatar.getLevels() + "</html>");
		avatarInfo.setFont(labelFont.deriveFont(20f));
		vitalsPanel = new JPanel();
		avatarName = new JLabel(avatar.getName());
		avatarName.setFont(labelFont.deriveFont(20f));
		
		avatarOccupation = new JLabel(avatar.getOccupation().getName());
		avatarOccupation.setFont(labelFont.deriveFont(20f));
		
		avatarLevel = new JLabel("Lv. "+avatar.getStatValue("Level"));
		avatarLevel.setFont(labelFont.deriveFont(20f));
		
		health = new JProgressBar(0, avatar.getStatValue("Life"));
		health.setStringPainted(true);
		health.setForeground(Color.RED);
		health.setFont(labelFont.deriveFont(15f));
		health.setString("Health: " + avatar.getStatValue("HP")+"/"+avatar.getStatValue("Life"));
		health.setValue(avatar.getStatValue("HP"));
		
		mana = new JProgressBar(0, avatar.getStatValue("Mana"));
		mana.setStringPainted(true);
		mana.setForeground(Color.BLUE);
		mana.setFont(labelFont.deriveFont(15f));
		mana.setString("Mana: " + avatar.getStatValue("MP")+"/"+avatar.getStatValue("Mana"));
		mana.setValue(avatar.getStatValue("MP"));
		
		lives = new JProgressBar(0, 3);
		lives.setStringPainted(true);
		lives.setForeground(Color.GRAY);
		lives.setFont(labelFont.deriveFont(15f));
		lives.setString("Lives: " + avatar.getStatValue("Lives")+"/"+3);
		lives.setValue(avatar.getStatValue("Lives"));
		
		avatarMana = new JLabel("Mana: "+avatar.getStatValue("MP")+"/"+avatar.getStatValue("Mana"));
		avatarMana.setFont(labelFont.deriveFont(20f));
		
		levelClassPanel = new JPanel();
		
		levelClassPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		levelClassPanel.add(avatarLevel);
		levelClassPanel.add(avatarOccupation);
		
		//vitalsPanel.setLayout(new GridLayout(4,1));
		vitalsPanel.add(avatarInfo);
		vitalsPanel.add(lives);
		vitalsPanel.add(health);
		vitalsPanel.add(mana);
		if (avatar.hasSpells()){
			vitalsPanel.add(new SpellView(avatar));
		}
		
		portraitView = new PortraitView(avatarPortrait);
		portraitView.setPreferredSize(new Dimension(210, 168));
		portraitView.repaint();
		
		portraitStatsPanel = new JPanel();
		portraitStatsPanel.setLayout(new GridLayout(1,2));
		portraitStatsPanel.add(portraitView);
		portraitStatsPanel.add(vitalsPanel);
		
		abilitiesPanel = new JPanel();
		abilitiesLabel = new JLabel("Ability Select");
		abilitiesLabel.setFont(labelFont.deriveFont(20f));
		
		abilitiesPanel.setLayout(new BoxLayout(abilitiesPanel, BoxLayout.Y_AXIS));
		abilitiesPanel.add(abilitiesLabel);
		
		abilityButtons = new ArrayList<JButton>();
		
		//TODO
		/*When abilities are implemented, we want to iterate through the avatar's abilities
		 * here, generate a corresponding JButton and add it to the ArrayList as well as the
		 * abilitiesPanel. If this is not the best solution due to controller issues, we can
		 * discuss other options. */
		//For now, default buttons
//		for(String key: 1) {
//			JButton temp = new JButton("Ability "+i);
//			temp.setFont(labelFont.deriveFont(20f));
//			temp.setFocusable(false);
//			abilityButtons.add(temp);
//			abilitiesPanel.add(abilityButtons.get(abilityButtons.size()-1));
//		}
		
		statusInfo.setLayout(new GridLayout(1,2));
		terminal.setText(avatar.getJournal());
		terminal.setEditable(false);
		JScrollPane scroll = new JScrollPane ( terminal );
	    scroll.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
		statusInfo.add(portraitStatsPanel);
		statusInfo.add(scroll);
		
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
	
	 public void updateStatus() {
		 avatarInfo.setText("<html>" + avatar.getOccupation().getName() + " " + avatar.getName() + "<br>Lv." + avatar.getStatValue("Level") +" Level Ups: " + avatar.getLevels() + "</html>");
		
		health.setMaximum(avatar.getStatValue("Life"));
		health.setString("Health: " + avatar.getStatValue("HP")+"/"+avatar.getStatValue("Life"));
		health.setValue(avatar.getStatValue("HP"));
		
		mana.setMaximum(avatar.getStatValue("Mana"));
		mana.setString("Mana: " + avatar.getStatValue("MP")+"/"+avatar.getStatValue("Mana"));
		mana.setValue(avatar.getStatValue("MP"));
		
		lives.setString("Lives: " + avatar.getStatValue("Lives")+"/"+3);
		lives.setValue(avatar.getStatValue("Lives"));
		
		if(avatar.isWriting()){
			terminal.setText(avatar.getJournal());
			avatar.doneWriting();
		}
 	}
}