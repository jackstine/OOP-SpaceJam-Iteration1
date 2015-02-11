import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*

StatusView Class
Displays player portrait, all relevant stats, and the character/system menu buttons

*/

public class StatusView extends JPanel {
	
	private Avatar avatar;
	private JPanel statusInfo;
	private JPanel buttonPanel;
	private JButton systemMenu;
	private JButton characterMenu;
	
	public StatusView(Avatar a) {
		avatar = a;
		
		statusInfo = new JPanel();
		
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new BorderLayout());
		systemMenu = new JButton("System");
		characterMenu = new JButton("Character");
		
		buttonPanel.add(systemMenu, BorderLayout.NORTH);
		buttonPanel.add(characterMenu, BorderLayout.SOUTH);
		
		add(statusInfo);
		add(buttonPanel);
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