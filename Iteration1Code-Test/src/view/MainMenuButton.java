package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class MainMenuButton extends JButton {
	public MainMenuButton() {
		super();
		customFeel();
	}
	
	public MainMenuButton(String s, Font f) {
		super(s);
		//customFeel();
		setForeground(Color.WHITE);
		setFont(f.deriveFont(40f));
		setContentAreaFilled(false);
		setBorderPainted(false);
	}
	
	private void customFeel() {
		setBackground(new Color(59, 89, 182));
        setForeground(Color.WHITE);
        setFocusPainted(false);
	}
}
