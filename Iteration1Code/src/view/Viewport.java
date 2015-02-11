package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*

Viewport Class
Contains a map of images for every object that needs to be rendered in game
Displays the MapView and StatusView on the same Panel

*/

public class Viewport extends JPanel {

	public Viewport() {
		
		MapView mapView = new MapView();
		StatusView statusView = new StatusView();
		
		this.setLayout(new BorderLayout());
		
		add(mapView, BorderLayout.CENTER);
		add(statusView, BorderLayout.SOUTH);
		
	}
	
	//TODO
	//does this consistently re-render the map and status view?
	public void display() {
		//mapView.render();
		//statusView.render();
	}
}