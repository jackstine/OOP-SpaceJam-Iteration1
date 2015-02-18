package view;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class CharacterCreationButton extends JButton {
	public CharacterCreationButton() {
		super();
		customFeel();
	}
	
	public CharacterCreationButton(ImageIcon i) {
		super(i);
		setContentAreaFilled(false);
		setBorderPainted(false);
	}
	
	private void customFeel() {
		setBackground(new Color(59, 89, 182));
        setForeground(Color.WHITE);
        setFocusPainted(false);
	}
}
