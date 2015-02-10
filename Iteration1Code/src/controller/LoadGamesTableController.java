package controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import view.View;

public class LoadGamesTableController {
	private View loadTable;
	private JButton backGameButton;
	private JLabel title;
	private JPanel table;
	private JPanel main;
	private JPanel back;

	public LoadGamesTableController(){
		loadTable = new View();
		backGameButton = new JButton("<html><span style='font-size:20px;'>Back</span></html>");
		title = new JLabel("<html><span style='font-size:40px;'><u>Load Game</u></span></html>", JLabel.CENTER);
		table = new JPanel();
		main = new JPanel();
		back = new JPanel();
		
		loadTable.getPanel().setPreferredSize(new Dimension(600, 600));
		loadTable.getPanel().setBorder(new LineBorder(Color.black, 5));
		loadTable.getPanel().setLayout(new BorderLayout());
		
		back.add(backGameButton);
		
		main.setLayout(new GridLayout(4,1));
		
		main.add(new JPanel());
		main.add(new JPanel());
		main.add(new JPanel());
		main.add(back);
		
		loadTable.getPanel().add(title, BorderLayout.NORTH);
		loadTable.getPanel().add(main, BorderLayout.CENTER);
		
		backGameButton.addActionListener(new BackButtonListener());
	}
	
	public View getView(){
		return loadTable;
	}
	
	public class BackButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			loadTable.setNext("Main");
			loadTable.setActive(false);
		}
	}
}
