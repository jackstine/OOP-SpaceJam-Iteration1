package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import view.View;

public class GameController {
	private View gameView;
	private JLabel msg;
	private JButton menu;
	//Game object goes here
	
	public GameController(){
		gameView = new View();
		menu = new JButton("menu");
		msg = new JLabel("We are in game.");
		
		menu.addActionListener(new SystemsMenu());
		
		gameView.getPanel().add(msg);
		gameView.getPanel().add(menu);
		//Instantiate Game object
	}
	
	public View getView(){
		return gameView;
	}
	
	public class SystemsMenu implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				String[] options = {"Quit",
                "Main"};
            	int n = JOptionPane.showOptionDialog(gameView.getPanel(),
            		    "How Should We Proceed:",
            		    "System",
            		    JOptionPane.YES_NO_OPTION,
            		    JOptionPane.QUESTION_MESSAGE,
            		    null,     //do not use a custom Icon
            		    options,  //the titles of buttons
            		    options[0]); //default button title
            	if(n != -1){
            		gameView.setNext(options[n]);
               	 	gameView.setRedraw(true);
            	}
			}
		}
	
}
