package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import utilities.FontHandler;
import utilities.Scaling;

@SuppressWarnings("serial")
public class MainMenuView extends View{
	private Font titleFont = new Font("serif", Font.PLAIN, 24);
	private Font buttonFont = new Font("serif", Font.PLAIN, 24);
	
	private JButton startGameButton;
	private JButton loadGameButton;
	private JButton quitGameButton;
	// private JLabel background;
	private JLabel title;
	
	private BufferedImage backgroundImage;
	
	public MainMenuView(ActionListener newAction, ActionListener loadAction, ActionListener quitAction){
		super();
		//Image scaledImage = originalImage.getScaledInstance(jPanel.getWidth(),jPanel.getHeight(),Image.SCALE_SMOOTH);
		
		backgroundImage = new BufferedImage(1, 1, 1);
		try {
			backgroundImage = ImageIO.read(new File("src/res/img/main_menu_bg.gif"));
		} catch (Exception e) {System.out.println("Didn't find.");}
		
		FontHandler fh = new FontHandler();
		titleFont = fh.ApocalypseNowFont();
		buttonFont = fh.AfterDisasterFont();
		
		startGameButton = new MainMenuButton("New Game", buttonFont);
		loadGameButton = new MainMenuButton("Load Game", buttonFont);
		quitGameButton = new MainMenuButton("Quit Game", buttonFont);

		
		title = new JLabel("THE DAVE AFTER TOMORROW");
		title.setFont(titleFont.deriveFont(100f));
		
		JPanel backGroundPanel = new ImagePanel("src/res/img/main_menu_bg.gif");
		backGroundPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 700, 5));
		// Insets insets = backGroundPanel.getInsets();
		// Dimension size = backGroundPanel.getPreferredSize();
		
		JButton ghost = new JButton();
		ghost.setPreferredSize(new Dimension(10, 225));
		ghost.setContentAreaFilled(false);
		ghost.setBorderPainted(false);
		
		setPreferredSize(new Dimension(Scaling.MAIN_MENU_WIDTH, Scaling.MAIN_MENU_HEIGHT));
		setLayout(new BorderLayout());
		
		startGameButton.setMaximumSize(new Dimension(200,50));
		loadGameButton.setMaximumSize(new Dimension(200,50));
		quitGameButton.setMaximumSize(new Dimension(200,50));
		
		backGroundPanel.add(title);
		backGroundPanel.add(ghost);
		
		backGroundPanel.add(startGameButton);
		backGroundPanel.add(loadGameButton);
		backGroundPanel.add(quitGameButton);
		
		add(backGroundPanel);
		
		startGameButton.addActionListener(newAction);
		quitGameButton.addActionListener(quitAction);
		loadGameButton.addActionListener(loadAction);
	}
}
