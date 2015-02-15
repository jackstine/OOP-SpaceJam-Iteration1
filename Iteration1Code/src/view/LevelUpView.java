package view;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import utilities.Scaling;

public class LevelUpView extends JInternalFrame {
	private JButton strength = new JButton("Strength");
	private JButton agility = new JButton("Agility");
	private JButton intellect = new JButton("Intellect");
	private JPanel levelUpMenu = new JPanel();
	private int dimensions[] = {Scaling.INTERNAL_X,Scaling.INTERNAL_Y,Scaling.INTERNAL_WIDTH,Scaling.INTERNAL_HEIGHT};
	public LevelUpView(ActionListener strengthAction, ActionListener agilityAction, ActionListener intellectAction) {
		strength.setFocusable(false);
		agility.setFocusable(false);
		intellect.setFocusable(false);
		
		getContentPane().add(new JLabel("You Leveled Up."), BorderLayout.CENTER);
		setBounds(dimensions[0], dimensions[1], dimensions[2], dimensions[3]);
		setTitle("Choose a Stat to Increase:");
		levelUpMenu.add(strength);
		levelUpMenu.add(agility);
		levelUpMenu.add(intellect);
		add(levelUpMenu);
		setVisible(true);
		
		strength.addActionListener(strengthAction);
		agility.addActionListener(agilityAction);
		intellect.addActionListener(intellectAction);
	}
}
