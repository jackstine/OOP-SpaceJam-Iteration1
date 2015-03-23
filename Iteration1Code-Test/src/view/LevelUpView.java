package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import utilities.FontHandler;
import utilities.Scaling;

@SuppressWarnings("serial")
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
		Font font = new FontHandler().AfterDisasterFont();
    	for(Entry<String, ActionListener> entry: m.entrySet()){
   			key = entry.getKey();
   			a = entry.getValue();
   			button = new JButton(key);
   			button.addActionListener(a);
   			button.setFocusable(false);
   			button.setFont(font.deriveFont(20f));
   			button.setForeground(Color.WHITE);
   			button.setContentAreaFilled(false);
   			button.setBorderPainted(false);
   			levelUpMenu.add(button);
   		 }
    	levelUpMenu.setBackground(Color.BLACK);
		add(levelUpMenu);
		setVisible(true);
	}
}
