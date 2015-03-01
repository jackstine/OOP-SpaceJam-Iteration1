package view;

import java.awt.Toolkit;

import javax.swing.JLayeredPane;


public abstract class View {
	private boolean redraw;
	private String next;
	protected JLayeredPane canvas;
	
	public View(){
		setRedraw(false);
		next = "";
		canvas = new JLayeredPane();
		canvas.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		canvas.setFocusable(true);
		canvas.setVisible(true);
	}
	
	
	/**
	 * Gets the next state.
	 * @return The "next state"
	 */
	public String getNext() {
		return next;
	}
	public void setNext(String next) {
		this.next = next;
	}
	public JLayeredPane getCanvas() {
		return canvas;
	}
	public void setCanvas(JLayeredPane canvas) {
		this.canvas = canvas;
	}
	/**
	 * Resets the state variables: <br>
	 * redraw = false <br>
	 * next = ""
	 * @return The "next state"
	 */
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
		canvas.add(new ImagePanel(s));
	}
	
}
