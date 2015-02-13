package view;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import controller.Apple;

/*

SystemMenuView Class
Displays system options when the game is paused by the user
Consists of three buttons for saving, quitting, and 'saving and quitting' the game

*/

public class SystemMenuView extends JInternalFrame {
	private JButton save = new JButton("Save");
	private JButton back = new JButton("Main Menu");
	private JButton ret = new JButton("Return");
	private JPanel systemsMenu = new JPanel();
	public SystemMenuView(ActionListener backAction, ActionListener saveAction, ActionListener retAction) {
		back.setFocusable(false);
		save.setFocusable(false);
		ret.setFocusable(false);
		
		getContentPane().add(new JLabel("System Menu"), BorderLayout.CENTER);
		setBounds(50, 50, 500, 500);
		setTitle("System Menu");
		systemsMenu.add(save);
		systemsMenu.add(back);
		systemsMenu.add(ret);
		add(systemsMenu);
		setVisible(true);
		
		back.addActionListener(backAction);
		save.addActionListener(saveAction);
		ret.addActionListener(retAction);
	}
}