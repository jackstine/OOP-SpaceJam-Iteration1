package Test;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Avatar;
import model.GameMap;
import controller.MapViewController;

public class ControllerTest extends JPanel{
	MapViewController mv;
	Avatar avatar;
	static JFrame frame;
	public static void main(String[]args){
		frame= new JFrame();
		ControllerTest ct = new ControllerTest();
		
		
		frame.setTitle("MapViewController");
		frame.add(ct);
		frame.pack();
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}
public ControllerTest(){
		
		setSize(new Dimension(800,600));
		setPreferredSize(new Dimension(800,600));
		setBackground(Color.BLACK);
		avatar= new Avatar();
		mv = new MapViewController(avatar,frame);
		//mv.setVisible(true);
	}

	public void paintComponent(Graphics g){
			
			g.setColor(Color.BLACK);
			g.fillRect(0,0,getWidth(),getHeight());
			avatar.loadImage(g);
			g.dispose();
			repaint();
			
			}
}
