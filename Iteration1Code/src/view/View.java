package view;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLayeredPane;
import javax.swing.JLayeredPane;

import utilities.Scaling;


public class View {
	private boolean redraw;
	private String next;
	private JLayeredPane panel;
	
	public View(){
		setRedraw(false);
		next = "";
		panel = new JLayeredPane();
		panel.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		panel.setFocusable(true);
		panel.setVisible(true);
	}
	public String getNext() {
		return next;
	}
	public void setNext(String next) {
		this.next = next;
	}
	public JLayeredPane getCanvas() {
		return panel;
	}
	public void setCanvas(JLayeredPane panel) {
		this.panel = panel;
	}
	
	public void reset(){
		setRedraw(false);
		next = "";
	}
	public boolean getRedraw() {
		return redraw;
	}
	public void setRedraw(boolean redraw) {
		this.redraw = redraw;
	}
	public void setBackground(String s) {
		panel.add(new ImagePanel(s));
	}
	
}
