package view;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JPanel;

import model.Avatar;
import model.GameMap;
import model.Location;
import model.Point;

public class MapView extends JPanel{
	private GameMap map;
	private Avatar avatar;
	private EntityView entityView;
	private TileView tiles[][];
	
	public MapView(GameMap map, EntityView entityView) {
		this.map = map;
		this.entityView = entityView;
		this.map.updateEntityLocation(avatar, new Location(3,3));
		this.setTileComponents();
	}
	
	void setTileComponents(){
		Point length = map.getMapLength();
		tiles = new TileView[length.getY()][length.getX()];
		for (int i = 0; i < length.getY();i++){
			for (int j =0; j < length.getX();j++){
				tiles[i][j] = new TileView(map.getTile(new Location(i,j)));
				this.add(tiles[i][j]);
			}
		}
	}

//	public void paintComponent(Graphics g){
//		System.out.println("painting the mapview");
//		Location location= map.getLocation(avatar);
//		int lowX=location.getX()-3;
//		int highX=location.getX()+3;
//		int lowY=location.getY()-3;
//		int highY=location.getY()+3;
//		for(int i=lowX;i<=highX;i++){
//			for(int j=lowY;j<=highY;j++){
//				map.getTile(new Location(i,j)).draw(g);
//			}
//		}
//	}
}