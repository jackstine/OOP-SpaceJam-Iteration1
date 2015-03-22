package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JPanel;

import utilities.Scaling;

@SuppressWarnings("serial")
public abstract class MapFlash extends JPanel {
	
	private JComponent mapView;
	private JComponent flashView;
	
	public abstract Color getFlashColor();
	
	
	protected void setView(){
        setFocusable(false);
        setPreferredSize(new Dimension(Scaling.GAME_VIEW_WIDTH, Scaling.GAME_VIEW_HEIGHT));
        setBounds(Scaling.BOARD_X,Scaling.BOARD_Y,Scaling.BOARD_WIDTH,Scaling.BOARD_HEIGHT);
        setOpaque(true);
        setBackground(getFlashColor());
        setVisible(true);
	}
	
	@Override 
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}
}
