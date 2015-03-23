package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import utilities.FontHandler;
import utilities.Scaling;

@SuppressWarnings("serial")
public class CharacterCreationView extends View {
	private JButton backGameButton;
	private JButton startAlchemistButton;
	private JButton startHunterButton;
	private JButton startTerminatorButton;
	private JLabel enterNameLabel;
	private JTextField enterNameField;
	private JLabel title;
	private JPanel backgroundPanel;
	// private final int STARTINGX=3;
	// private final int STARTINGY=3;

	public CharacterCreationView( ActionListener backAction, ActionListener alchemistAction, ActionListener terminatorAction, ActionListener hunterAction ){
		setPreferredSize(new Dimension(Scaling.CHARACTER_CREATION_WIDTH, Scaling.CHARACTER_CREATION_HEIGHT));
		//canvas.setBorder(new LineBorder(Color.black, 5));
		setLayout(new BorderLayout());
		
		Font titleFont = new Font("serif", Font.PLAIN, 24);
		Font labelFont = new Font("serif", Font.PLAIN, 24);
		
		FontHandler fh = new FontHandler();
		titleFont = fh.ApocalypseNowFont();
		labelFont = fh.AfterDisasterFont();
		
		title = new JLabel("CHARACTER CREATION");
		title.setFont(titleFont.deriveFont(100f));
		
		backgroundPanel = new ImagePanel("src/res/img/main_menu_bg.gif");
		
		backgroundPanel.setLayout(new GridBagLayout());//(FlowLayout.CENTER, 350, 5));
		GridBagConstraints c = new GridBagConstraints();
		
		ImageIcon terminatorButtonLogo = new ImageIcon("src/res/img/terminator3.png");
		ImageIcon alchemistButtonLogo = new ImageIcon("src/res/img/alchemist3.png");
		ImageIcon hunterButtonLogo = new ImageIcon("src/res/img/hunter3.png");
		
		backGameButton = new MainMenuButton("       <Back>", labelFont);
		
		startAlchemistButton = new CharacterCreationButton(alchemistButtonLogo);
		startTerminatorButton = new CharacterCreationButton(terminatorButtonLogo);
		startHunterButton = new CharacterCreationButton(hunterButtonLogo);
		
		JLabel terminatorLabel = new JLabel("  Terminator");
		terminatorLabel.setForeground(Color.WHITE);
		Font labelFontRedux = labelFont.deriveFont(40f);
		terminatorLabel.setFont(labelFontRedux);
		
		JLabel alchemistLabel = new JLabel("   Alchemist");
		alchemistLabel.setForeground(Color.WHITE);
		alchemistLabel.setFont(labelFontRedux);
		
		JLabel hunterLabel = new JLabel("        Hunter");
		hunterLabel.setForeground(Color.WHITE);
		hunterLabel.setFont(labelFontRedux);
		
		
		enterNameLabel = new JLabel("Name your character");
		enterNameLabel.setFont(labelFontRedux);
		enterNameLabel.setForeground(Color.WHITE);
		
		enterNameField = new JTextField("Arnold");
		enterNameField.setHorizontalAlignment(JTextField.CENTER);
		enterNameField.setFont(labelFontRedux);
		enterNameField.setBackground(new Color(255,255,255,130));
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.ipady = 30;
		c.gridwidth = 3;
		backgroundPanel.add(title, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 2;
		backgroundPanel.add(enterNameLabel, c);
		c.gridx = 2;
		c.gridy = 1;
		c.gridwidth = 1;
		backgroundPanel.add(backGameButton, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 3;
		backgroundPanel.add(enterNameField, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 1;
		backgroundPanel.add(startTerminatorButton, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 3;
		c.gridwidth = 1;
		backgroundPanel.add(startAlchemistButton, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 3;
		c.gridwidth = 1;
		backgroundPanel.add(startHunterButton, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 4;
		c.gridwidth = 1;
		//c.ipady = -20;
		//backgroundPanel.add(terminatorLabel, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 4;
		c.gridwidth = 1;
		//c.ipady = -20;
		//backgroundPanel.add(alchemistLabel, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 4;
		c.gridwidth = 1;
		//c.ipady = -20;
		//backgroundPanel.add(hunterLabel, c);
		c.fill = GridBagConstraints.HORIZONTAL;

		
		//back.add(backGameButton);
		
		
		//canvas.add(main, BorderLayout.CENTER);
		
		add(backgroundPanel);
		
		backGameButton.addActionListener(backAction);
		startAlchemistButton.addActionListener(alchemistAction);
		startTerminatorButton.addActionListener(terminatorAction);
		startHunterButton.addActionListener(hunterAction);
	}
	
	public String avatarName(){
		return enterNameField.getText();
	}
}
