package view;

import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.JLayeredPane;


@SuppressWarnings("serial")
public abstract class View extends JLayeredPane {
	private boolean redraw;
	private String next;
	
	public View(){
		setRedraw(false);
		next = "";
		setBackground(Color.BLACK);
		setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		setFocusable(true);
		setVisible(true);
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
		add(new ImagePanel(s));
	}
	/**
	 * @param s -String to compare with the next state
	 * @return -boolean indicating if String s is equal to "next state"
	 */
	public boolean nextStateEquals(String s){
		if(next.equals(s)){
			return true;
		}
		return false;
	}
	
}
