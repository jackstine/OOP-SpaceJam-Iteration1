package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.occupation.AvatarAlchemist;
import model.occupation.AvatarHunter;
import model.occupation.AvatarTerminator;
import model.occupation.Occupation;
import view.CharacterCreationView;
import view.View;


public class CharacterCreationController {
	
	private CharacterCreationView charCreation = new CharacterCreationView(new BackButtonListener(),new AlchemistSelectListener(),new TerminatorSelectListener(),new HunterSelectListener());
	private String name = "";
	private Occupation occ = new AvatarHunter();
	
	public View getView(){
		return charCreation;
	}
	
	public String getName(){
		return name;
	}
	
	public Occupation getOccupation(){
		return occ;
	}
	
	public class BackButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			charCreation.setNext("Main");
			charCreation.setRedraw(true);
			
		}
	}
	
	public class AlchemistSelectListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			occ = new AvatarAlchemist();
			name = charCreation.avatarName();
			charCreation.setNext("New"); //Game View
			charCreation.setRedraw(true);
			
		}
	}
	
	public class TerminatorSelectListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			occ = new AvatarTerminator();
			name = charCreation.avatarName();
			charCreation.setNext("New"); //Game View
			charCreation.setRedraw(true);
			
		}
	}
	
	public class HunterSelectListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			occ = new AvatarHunter();
			name = charCreation.avatarName();
			charCreation.setNext("New"); //Game View
			//gameToCreate.getMap().updateEntityLocation(gameToCreate.getAvatar(), new Location(STARTINGX,STARTINGY));
			charCreation.setRedraw(true);
			
		}
	}

}
