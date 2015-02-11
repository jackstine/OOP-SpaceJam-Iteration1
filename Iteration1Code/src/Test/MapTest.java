package Test;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class MapTest extends JPanel  {
	GameMap map;
	public static void main(String[] args){
			
			MapTest game= new MapTest();
			JFrame frame= new JFrame();
			frame.setTitle("Map");
			frame.add(game);
			frame.pack();
			frame.setResizable(false);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
			
			}

	public MapTest(){
		
		setSize(new Dimension(800,600));
		setPreferredSize(new Dimension(800,600));
		setBackground(Color.BLACK);
		map= new GameMap();
	}

	public void paintComponent(Graphics g){
			
			//g.setColor(Color.BLACK);
			g.fillRect(0,0,getWidth(),getHeight());
			map.draw(g);
			g.dispose();
			repaint();
			
			}
			
	}