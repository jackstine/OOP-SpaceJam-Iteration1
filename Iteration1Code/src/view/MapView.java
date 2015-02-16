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
		Point length = map.getMapLength();
		Location avatarLocation= map.getLocation(avatar);
		int lowX=avatarLocation.getX()-3;
		int highX=avatarLocation.getX()+3;
		int lowY=avatarLocation.getY()-3;
		int highY = avatarLocation.getY()+3;
		for(int i=lowX;i<=highX;i++){
			for(int j=lowY;j<=highY;j++){
				Location current = new Location(i,j);
				this.tiles[i][j].paintComponent(g);
				if (avatarLocation.equals(current)){
					this.entityView.paintComponent(g);
				}
			}
		}
		add(this.entityView);
	}	
	public Dimension getPreferredSize(){
		return new Dimension( Scaling.GAME_VIEW_WIDTH , Scaling.GAME_VIEW_HEIGHT);
	}
}