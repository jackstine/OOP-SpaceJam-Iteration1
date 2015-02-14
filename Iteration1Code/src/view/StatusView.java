package view;

import java.awt.*;
import java.awt.event.*;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;

import model.*;

/*

StatusView Class
Displays player portrait, all relevant stats, and the character/system menu buttons

*/

public class StatusView extends JPanel {
	
	private Avatar avatar;
	private JPanel statusInfo;
	
	private PortraitView portraitView;
	
	private JPanel buttonPanel;
	private JButton systemMenu;
	private JButton characterMenu;
	
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
		System.out.println("added1");
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(2,1));
		systemMenu = new JButton("System");
		characterMenu = new JButton("Character");
		
		portraitView = new PortraitView(avatarPortrait);
		portraitView.setPreferredSize(new Dimension(210, 168));
		portraitView.repaint();
		
		statusInfo.setLayout(new BorderLayout());
		statusInfo.add(portraitView, BorderLayout.WEST);
		
		buttonPanel.add(systemMenu);//, BorderLayout.NORTH);
		buttonPanel.add(characterMenu);//, BorderLayout.SOUTH);
		
		add(statusInfo, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.EAST);
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