package Test;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.image.*;
import java.io.*;

import javax.imageio.ImageIO;

import controller.MapViewController;
import model.GameMap;
import model.Avatar;
import model.Location;



public class MapTest extends JPanel  {
	GameMap map;
	MapViewController mv;
	Avatar avatar;
	static JFrame frame;
	BufferedImage image;
	private final int MIDDLE=300;
	
	public static void main(String[] args){
		frame= new JFrame();
		MapTest mt= new MapTest();
		frame.setTitle("MapTest");
		frame.add(mt);
		frame.pack();
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
			
			}

	public MapTest(){
		setSize(new Dimension(800,600));
		setPreferredSize(new Dimension(700, 700));
		setBackground(Color.BLACK);
		map= new GameMap();
		avatar= new Avatar();
		map.updateEntityLocation(avatar, new Location(3,3));
		mv = new MapViewController(map,avatar,frame);
		image=avatar.getImage();
	}

	public void paintComponent(Graphics g){
		int x= map.getLocation(avatar).getX();
		int y=map.getLocation(avatar).getY();
		g.setColor(Color.BLACK);
		g.fillRect(0,0,getWidth(),getHeight());
		map.draw(g);
		g.drawImage(image,MIDDLE,MIDDLE,null);
		g.dispose();
		repaint();
	}
			
	}