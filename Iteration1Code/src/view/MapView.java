package view;
import java.awt.Dimension;
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
	private TileView tiles[][];
	
	public MapView(GameMap map, EntityView entityView, Avatar avatar) {
		this.map = map;
		this.entityView = entityView;
		this.avatar = avatar;
		this.map.updateEntityLocation(this.avatar, new Location(3,3));
		this.setTileComponents();
		this.setLayout(new GridLayout(7,7));
	}
	
	void setTileComponents(){
		Point length = map.getMapLength();
		Location avatarLocation= map.getLocation(avatar);
		System.out.println(avatarLocation);
		int lowX=avatarLocation.getX()-3;
		int highX=avatarLocation.getX()+3;
		int lowY=avatarLocation.getY()-3;
		int highY = avatarLocation.getY()+3;
		tiles = new TileView[length.getY()][length.getX()];
		for(int i=lowX;i<=highX;i++){
			for(int j=lowY;j<=highY;j++){
				Location current = new Location(i,j);
				if (avatarLocation.equals(current)){
					System.out.println("Hit the Spot");
					add(this.entityView);
				}
//				else{
					System.out.println(new Location(i,j));
					tiles[i][j] = new TileView(map.getTile(new Location(i,j)));
					this.add(tiles[i][j]);
//				}
			}
		}
		add(this.entityView);
	}
	
	public Dimension getPreferredSize(){
		return new Dimension( Scaling.GAME_VIEW_WIDTH , Scaling.GAME_VIEW_HEIGHT);
	}
}