package view;
import javax.swing.JPanel;


public class View {
	private boolean active;
	private String next;
	private JPanel panel;
	
	public View(){
		active = true;
		next = "";
		panel = new JPanel();
	}
	public View(JPanel panel){
		this.setNext("");
		this.setPanel(panel);
		this.setActive(true);
	}
	public String getNext() {
		return next;
	}
	public void setNext(String next) {
		this.next = next;
	}
	public JPanel getPanel() {
		return panel;
	}
	public void setPanel(JPanel panel) {
		this.panel = panel;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	public void reset(){
		active = true;
		next = "";
	}
	
}
