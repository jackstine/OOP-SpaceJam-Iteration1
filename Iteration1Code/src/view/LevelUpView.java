package view;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import utilities.Scaling;

public class LevelUpView extends JInternalFrame {
	private JButton save = new JButton("Save");
	private JButton back = new JButton("Main Menu");
	private JButton ret = new JButton("Return");
	private JPanel systemsMenu = new JPanel();
	private int dimensions[] = {Scaling.INTERNAL_X,Scaling.INTERNAL_Y,Scaling.INTERNAL_WIDTH,Scaling.INTERNAL_HEIGHT};
	public LevelUpView(ActionListener backAction, ActionListener saveAction, ActionListener retAction) {
		back.setFocusable(false);
		save.setFocusable(false);
		ret.setFocusable(false);
		
		getContentPane().add(new JLabel("System Menu"), BorderLayout.CENTER);
		setBounds(dimensions[0], dimensions[1], dimensions[2], dimensions[3]);
		setTitle("System Menu");
		systemsMenu.add(save);
		systemsMenu.add(back);
		systemsMenu.add(ret);
		add(systemsMenu);
		setVisible(true);
		
		back.addActionListener(backAction);
		save.addActionListener(saveAction);
		ret.addActionListener(retAction);
	}
}
