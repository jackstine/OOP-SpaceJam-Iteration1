import javax.swing.JPanel;


public class View {
	private boolean done;
	private String next;
	private JPanel panel;
	
	public View(){
		done = false;
	}
	public View(String next, JPanel panel){
		this.setNext(next);
		this.setPanel(panel);
		this.setDone(false);
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
	public boolean isDone() {
		return done;
	}
	public void setDone(boolean done) {
		this.done = done;
	}
	
	public void reset(){
		done = false;
		next = "";
	}
	
}
