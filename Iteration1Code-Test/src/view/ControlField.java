package view;


import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class ControlField extends JPanel{
	JTextField input;
	JLabel label;
	public ControlField(String text, String key){
		label = new JLabel(text+": ");
		input = new JTextField(key,6);
		//setLayout(new GridLayout(2,1));
		add(label);
		add(input);
		setBorder(BorderFactory.createTitledBorder(text));
		setBorder(new LineBorder(Color.black, 2));
	}
	
	public void setInput(String key){
		input.setText(key);
	}
	
	public String getInput(){
		return input.getText();
	}
	
}
