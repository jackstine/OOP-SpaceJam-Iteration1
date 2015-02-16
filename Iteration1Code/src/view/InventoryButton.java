package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

public class InventoryButton extends JButton{
	public InventoryButton() {
		super();
		customFeel();
	}
	
	public InventoryButton(String s, Font f) {
		super(s);
		//customFeel();
		//setForeground(Color.WHITE);
		setFont(f.deriveFont(30f));
		setContentAreaFilled(false);
		setBorderPainted(false);
	}
	
	private void customFeel() {
		setBackground(new Color(59, 89, 182));
        //setForeground(Color.WHITE);
        setFocusPainted(false);
	}
}
