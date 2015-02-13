package view;
import javax.swing.JPanel;


public class View {
	private boolean redraw;
	private String next;
	private JPanel panel;
	
	public View(){
		setRedraw(false);
		next = "";
		panel = new JPanel();
		panel.setFocusable(true);
		panel.setVisible(true);
	}
	public View(JPanel panel){
		this.setNext("");
		this.setPanel(panel);
		this.setRedraw(false);
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
