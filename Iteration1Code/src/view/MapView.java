package view;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JPanel;

import utilities.Scaling;
import model.Avatar;
import model.GameMap;
import model.Location;
import model.Point;

public class MapView extends JPanel{
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
		this.setLayout(new GridLayout(7,7));
	}
	
	void setTileComponents(){
		
		this.tiles = new TileView[map.getMapLength().getY()][map.getMapLength().getX()];
		Point length = map.getMapLength();
		Location avatarLocation= map.getLocation(avatar);
		for(int i = 0;i < this.map.getMapLength().getY();i++){
			for(int j = 0; j < this.map.getMapLength().getX();j++){
				this.tiles[i][j] = new TileView(map.getTile(new Location(j,i)));
			}
		}
	}
	
	public void paint(Graphics g){
//		Point length = map.getMapLength();
//		Location avatarLocation= map.getLocation(avatar);
//		Point mapLocation = map.getDelta();
//		int lowX=avatarLocation.getX()-3 + (mapLocation.getX()/Scaling.TILE_WIDTH);
//		int highX=avatarLocation.getX()+3 + (mapLocation.getX()/Scaling.TILE_WIDTH);
//		int lowY=avatarLocation.getY()-3 + (mapLocation.getY()/Scaling.TILE_WIDTH);
//		int highY = avatarLocation.getY()+3 + (mapLocation.getY()/Scaling.TILE_WIDTH);
//		System.out.println(mapLocation);
//		System.out.println(lowX + "  "+highX+"  "+lowY+"  "+highY);
//		for(int i=lowX;i<=highX;i++){
//			for(int j=lowY;j<=highY;j++){
//				Location current = new Location(i,j);
//				this.tiles[i][j].paintComponent(g);
//				if (avatarLocation.equals(current)){
//					this.entityView.paintComponent(g);
//				}
//			}
//		}
		int RANGE = 3;
		
		Location location= this.map.getLocation(this.avatar);
		int lowX=location.getX()-RANGE;
		int highX=location.getX()+RANGE;
		int lowY=location.getY()-RANGE;
		int highY=location.getY()+RANGE;
		for(int i=lowX;i<=highX;i++){
			for(int j=lowY;j<=highY;j++){
				int delta1= this.map.getTile(new Location(j,i)).getDeltaX();
				int delta2= this.map.getTile(new Location(j,i)).getDeltaY();
				this.map.getTile(new Location(j,i)).setDeltaX(delta1+ this.map.getDelta().getX());  
				this.map.getTile(new Location(j,i)).setDeltaY(delta2+ this.map.getDelta().getY());  
				this.tiles[j][i].paintComponent(g);
				if (location.equals(new Location(j,i))){
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