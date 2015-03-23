package view;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import utilities.FontHandler;
import utilities.Scaling;

/*

SystemMenuView Class
Displays system options when the game is paused by the user
Consists of three buttons for saving, quitting, and 'saving and quitting' the game

*/

@SuppressWarnings("serial")
public class SystemMenuView extends JInternalFrame {
	private JButton save = new JButton("Save");
	private JButton back = new JButton("Main Menu");
	private JButton ret = new JButton("Return");
	private JButton config = new JButton("Controls");
	private FontHandler fh = new FontHandler();
	private Font buttonFont;
	private JPanel systemsMenu = new JPanel();
	private int dimensions[] = {Scaling.INTERNAL_X,Scaling.INTERNAL_Y,Scaling.INTERNAL_WIDTH,Scaling.INTERNAL_HEIGHT};
	public SystemMenuView(ActionListener backAction, ActionListener saveAction, ActionListener retAction, ActionListener uiConfig) {
		back.setFocusable(false);
		save.setFocusable(false);
		ret.setFocusable(false);
		config.setFocusable(false);
		
		//set Fonts of stuff
		buttonFont = fh.AfterDisasterFont();
		save.setFont(buttonFont.deriveFont(20f));
		save.setForeground(Color.WHITE);
		save.setContentAreaFilled(false);
		save.setBorderPainted(false);
		back.setFont(buttonFont.deriveFont(20f));
		back.setForeground(Color.WHITE);
		back.setContentAreaFilled(false);
		back.setBorderPainted(false);
		ret.setFont(buttonFont.deriveFont(20f));
		ret.setForeground(Color.WHITE);
		ret.setContentAreaFilled(false);
		ret.setBorderPainted(false);
		config.setFont(buttonFont.deriveFont(20f));
		config.setForeground(Color.WHITE);
		config.setContentAreaFilled(false);
		config.setBorderPainted(false);
		
		getContentPane().add(new JLabel("System Menu"), BorderLayout.CENTER);
		setBounds(dimensions[0], dimensions[1], dimensions[2], dimensions[3]);
		setTitle("System Menu");
		systemsMenu.add(save);
		systemsMenu.add(back);
		systemsMenu.add(config);
		systemsMenu.add(ret);
		systemsMenu.setBackground(Color.BLACK);
		add(systemsMenu);
		setVisible(true);
		
		back.addActionListener(backAction);
		save.addActionListener(saveAction);
		ret.addActionListener(retAction);
		config.addActionListener(uiConfig);
	}
}