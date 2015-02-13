package view;
import java.awt.Toolkit;

import javax.swing.JLayeredPane;


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
	
}
