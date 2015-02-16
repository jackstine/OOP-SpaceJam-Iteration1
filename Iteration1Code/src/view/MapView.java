package view;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JComponent;
import javax.swing.JPanel;

import utilities.Scaling;
import model.Avatar;
import model.GameMap;
import model.Location;
import model.Point;

public class MapView extends JComponent{
	private GameMap map;
	private Avatar avatar;
	private EntityView entityView;
	private TileView[][] tiles;
	
	public MapView(GameMap map, EntityView entityView, Avatar avatar) {
		this.map = map;
		this.entityView = entityView;
		this.avatar = avatar;
		this.map.updateEntityLocation(this.avatar, new Location(3,3));
		this.setTileComponents();
//		this.setLayout(new GridLayout(7,7));
//		this.setComponents();
	}
	
	void setTileComponents(){
		
		this.tiles = new TileView[map.getMapLength().getY()][map.getMapLength().getX()];
		for(int i = 0;i < this.map.getMapLength().getY();i++){
			for(int j = 0; j < this.map.getMapLength().getX();j++){
				this.tiles[i][j] = new TileView(map.getTile(new Location(j,i)));
			}
		}
	}
	
	public void paintComponent(Graphics g){
		int RANGE = 3;
		this.setTileComponents();
		Location location= this.map.getLocation(this.avatar);
		int lowX=location.getX()-RANGE;
		int highX=location.getX()+RANGE;
		int lowY=location.getY()-RANGE;
		int highY=location.getY()+RANGE;
		System.out.println(lowX +"  "+highX+ "   " + lowY+"  "+highY);
		for(int i=lowX;i<=highX;i++){
			for(int j=lowY;j<=highY;j++){
				this.tiles[j][i].paintComponent(g, lowX, lowY);
				if (location.equals(new Location(i,j))){
					this.entityView.paintComponent(g);
				}
			}
		}
		repaint();
		g.dispose();
	}	
	public Dimension getPreferredSize(){
		return new Dimension( Scaling.GAME_VIEW_WIDTH , Scaling.GAME_VIEW_HEIGHT);
	}
}