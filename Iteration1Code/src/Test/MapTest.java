package Test;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import controller.MapViewController;
import model.GameMap;
import model.Avatar;

public class MapTest extends JPanel  {
	GameMap map;
	MapViewController mv;
	Avatar avatar;
	static JFrame frame;
	
	public static void main(String[] args){
		frame= new JFrame();
		MapTest mapTest = new MapTest();
		frame.setTitle("MapTest");
		frame.add(mapTest);
		frame.pack();
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		while(true){
			frame.repaint();
			mapTest.repaint();
		}
			
			}

	public MapTest(){
		
		setSize(new Dimension(800,600));
		setPreferredSize(new Dimension(800,600));
		setBackground(Color.BLACK);
		map= new GameMap();
		avatar= new Avatar();
		mv = new MapViewController(avatar,frame);
	}

	public void paintComponent(Graphics g){
			
			g.setColor(Color.BLACK);
			g.fillRect(0,0,getWidth(),getHeight());
			map.draw(g);
			avatar.loadImage(g);
			g.dispose();
			repaint();
			
			}
			
	}