package view;

import java.awt.Color;

import javax.swing.JPanel;

public abstract class MapFlash extends JPanel {
	
	public abstract Color getFlashColor();
	
	public void paint() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				
				
			}
			
		}).start();
	}
}
