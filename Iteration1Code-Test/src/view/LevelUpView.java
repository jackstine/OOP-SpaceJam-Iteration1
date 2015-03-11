package view;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Skill;
import controller.GameController.LevelStat;
import utilities.Scaling;

public class LevelUpView extends JInternalFrame {
	private JPanel levelUpMenu = new JPanel();
	private int dimensions[] = {Scaling.INTERNAL_X,Scaling.INTERNAL_Y,Scaling.INTERNAL_WIDTH,Scaling.INTERNAL_HEIGHT};
	public LevelUpView(Map<String, ActionListener> m) {
		getContentPane().add(new JLabel("You Leveled Up."), BorderLayout.CENTER);
		setBounds(dimensions[0], dimensions[1], dimensions[2], dimensions[3]);
		setTitle("Choose a Stat to Increase:");
		String key;
		ActionListener a;
		JButton button = new JButton();
    	for(Entry<String, ActionListener> entry: m.entrySet()){
   			key = entry.getKey();
   			a = entry.getValue();
   			button = new JButton(key);
   			button.addActionListener(a);
   			button.setFocusable(false);
   			levelUpMenu.add(button);
   		 }
		add(levelUpMenu);
		setVisible(true);
	}
}
