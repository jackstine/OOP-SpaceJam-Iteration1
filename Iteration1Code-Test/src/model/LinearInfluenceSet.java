package model;

import java.util.ArrayList;
import java.util.Collection;

import utilities.Directions;
import utilities.Scaling;

public class LinearInfluenceSet extends InfluenceSet {
	
	public LinearInfluenceSet(GameMap map, Tile source, int radius, int direction) {
		setMap(map);
		setSource(source);
		setRadius(radius);
		setDirection(direction);
	}

	@Override
	public Collection<InfluenceTile> getInfluenceSet() {
		ArrayList<InfluenceTile> list = new ArrayList<InfluenceTile>();
		int width= map.getWidth()/Scaling.TILE_WIDTH;
		int height= map.getHeight()/Scaling.TILE_HEIGHT;
		int dirX=Directions.getPoint(direction).getX();
		int dirY=Directions.getPoint(direction).getY();
		try{
			for(int i=0;i<width && i<height && i<=radius;i++){  
				list.add(new InfluenceTile(source,i));
				int x=source.getLocation().getX();
				int y= source.getLocation().getY();
				x+=dirX;
				y+=dirY;
				if(x!=height && y!=width && x>=0 && y>=0) 
					setSource(map.getTile(new Point(x,y)));
				else break;
			}
			
		} catch(Exception e){
			e.printStackTrace();
		}
		
		
		return list;
	}
	

}
