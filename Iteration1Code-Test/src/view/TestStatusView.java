package view;

import javax.swing.JFrame;

import model.Avatar;
import model.occupation.Terminator;


public class TestStatusView extends JFrame{
	
	private StatusView statusView;
	
	public TestStatusView() {
		Avatar testAvatar = new Avatar(new Terminator());
		testAvatar.setName("Arnold");
		statusView = new StatusView(testAvatar);
		add(statusView);
	}
	
	public static void main(String[] args) {
		TestStatusView tsv = new TestStatusView();
		tsv.setSize(1000,230);
		tsv.setVisible(true);
		tsv.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
