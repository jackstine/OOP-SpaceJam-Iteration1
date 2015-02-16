package view;

import java.awt.Color;

import javax.swing.JButton;

public class MainMenuButton extends JButton {
	public MainMenuButton() {
		super();
		customFeel();
	}
	
	public MainMenuButton(String s) {
		super(s);
		customFeel();
	}
	
	private void customFeel() {
		setBackground(new Color(59, 89, 182));
        setForeground(Color.WHITE);
        setFocusPainted(false);
	}
}
