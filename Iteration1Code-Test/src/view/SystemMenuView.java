package view;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

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
	private JPanel systemsMenu = new JPanel();
	private int dimensions[] = {Scaling.INTERNAL_X,Scaling.INTERNAL_Y,Scaling.INTERNAL_WIDTH,Scaling.INTERNAL_HEIGHT};
	public SystemMenuView(ActionListener backAction, ActionListener saveAction, ActionListener retAction, ActionListener uiConfig) {
		back.setFocusable(false);
		save.setFocusable(false);
		ret.setFocusable(false);
		config.setFocusable(false);
		
		getContentPane().add(new JLabel("System Menu"), BorderLayout.CENTER);
		setBounds(dimensions[0], dimensions[1], dimensions[2], dimensions[3]);
		setTitle("System Menu");
		systemsMenu.add(save);
		systemsMenu.add(back);
		systemsMenu.add(config);
		systemsMenu.add(ret);
		add(systemsMenu);
		setVisible(true);
		
		back.addActionListener(backAction);
		save.addActionListener(saveAction);
		ret.addActionListener(retAction);
		config.addActionListener(uiConfig);
	}
}