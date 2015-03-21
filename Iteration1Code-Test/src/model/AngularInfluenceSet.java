package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;

import utilities.Directions;
import utilities.Scaling;


public class AngularInfluenceSet extends InfluenceSet {
	private int[] dx = new int[] {0, 1, 0, -1, 1, 1, -1, -1}; 
	private int[] dy = new int[] {1, 0, -1, 0, 1, -1, -1, 1}; 
	private int[] south= new int[]{7,0,4};
	private int[] east = new int[]{5,1,4};
	private int[] west= new int[]{6,3,7};
	private int[] north= new int[]{6,2,5};
	private int[] northeast= new int[]{2,1,5};
	private int[] southwest= new int[]{3,0,7};
	private int[] northwest= new int[]{2,3,6};
	
	public AngularInfluenceSet(GameMap map, Tile source, int radius, int direction) {
		setMap(map);
		setSource(source);
		setRadius(radius);
		setDirection(direction);
	}

	@Override
	public Collection<InfluenceTile> getInfluenceSet() {
		Collection<InfluenceTile> list= new ArrayList<InfluenceTile>();
		Queue<InfluenceTile> queue= new LinkedList<InfluenceTile>();
		//queue.add(new QueueInfluenceTile(source,0));
		//((QueueInfluenceTile) source).setVisited(true); //change later..no casting.
		boolean[][]visited= new boolean[map.getWidth()][map.getHeight()];
		list.add(new InfluenceTile(source,0));
		int x= source.getLocation().getX();
		int y= source.getLocation().getY();
		int initX=x;
		int initY=y;
		visited[x][y]=true;
		int curr=1;
		int check=radius*radius;
		switch(direction){
		case 9:
			boolean first=true;
			int length=northeast.length-1;
			int r=0;
			if(x+1<map.getWidth()/Scaling.TILE_WIDTH && y-1>=0){
				source=map.getTile(new Point(x+1,y-1));
				queue.add(new InfluenceTile(source,curr));
			}
			while(!queue.isEmpty() && curr<=check-1){
				InfluenceTile t=queue.remove();
				list.add(t);
				if(first==false) length=northeast.length;
				for(int i=0;i<length;i++){
					first=false;
					 x= t.getLocation().getX() + dx[northeast[i]];
					 y= t.getLocation().getY() + dy[northeast[i]];
					 if(x<map.getWidth()/Scaling.TILE_WIDTH && y<map.getHeight()/Scaling.TILE_HEIGHT){
						 if(!visited[x][y]){  
							 source= map.getTile(new Point(x,y));
							 if(x-initX==initY-y) r=x-initX+1;
							 else r=Math.max(x-initX,initY-y);
							 queue.add(new InfluenceTile(source,r));
							 visited[x][y]=true;
						 }
					 }
				}
				curr++;
			}
			
		case 2:
			if(y+1<=map.getHeight()){
				source=map.getTile(new Point(x,y+1));
				queue.add(new InfluenceTile(source,curr));
			}
			while(!queue.isEmpty() && curr<=check){
				InfluenceTile t=queue.remove();
				list.add(t);
				for(int i=0;i<south.length;i++){
					 x= t.getLocation().getX() + dx[south[i]];
					 y= t.getLocation().getY() + dy[south[i]];
				if(!visited[x][y]){  
					//System.out.println("x: " + x + " y: " + y);
					if(x<map.getWidth()/Scaling.TILE_WIDTH && y<map.getHeight()/Scaling.TILE_HEIGHT){
					source= map.getTile(new Point(x,y));
					queue.add(new InfluenceTile(source,y-initY));
					visited[x][y]=true;
					}
				}
				}
				curr++;
			}
		case 4:
			if(x-1>=0){
				source=map.getTile(new Point(x-1,y));
				queue.add(new InfluenceTile(source,curr));
			}
			while(!queue.isEmpty() && curr<=check){
				InfluenceTile t=queue.remove();
				list.add(t);
				for(int i=0;i<west.length;i++){
					 x= t.getLocation().getX() + dx[west[i]];
					 y= t.getLocation().getY() + dy[west[i]];
				if(!visited[x][y]){  
					//System.out.println("x: " + x + " y: " + y);
					if(x<map.getWidth()/Scaling.TILE_WIDTH && y<map.getHeight()/Scaling.TILE_HEIGHT){
					source= map.getTile(new Point(x,y));
					queue.add(new InfluenceTile(source,initX-x));
					visited[x][y]=true;
					}
				}
				}
				curr++;
			}
			
		case 6:
			if(x+1<=map.getWidth()){
				source=map.getTile(new Point(x+1,y));
				queue.add(new InfluenceTile(source,curr));
			}
			while(!queue.isEmpty() && curr<=check){
				InfluenceTile t=queue.remove();
				list.add(t);
				for(int i=0;i<east.length;i++){
					 x= t.getLocation().getX() + dx[east[i]];
					 y= t.getLocation().getY() + dy[east[i]];
					// System.out.println("x: " + x + "y: " + y); //check bounds for all
					 if(x<map.getWidth()/Scaling.TILE_WIDTH && y<map.getHeight()/Scaling.TILE_HEIGHT){
						 if(!visited[x][y]){  
							 source= map.getTile(new Point(x,y));
							 queue.add(new InfluenceTile(source,x-initX));
							 visited[x][y]=true;
						 }
					 }
				}
				curr++;
			}
		case 7:
			first=true;
			length=northwest.length-1;
			 r=0;
			if(x-1>=0 && y-1>=0){
				source=map.getTile(new Point(x-1,y-1));
				queue.add(new InfluenceTile(source,curr));
			}
			while(!queue.isEmpty() && curr<=check-1){
				InfluenceTile t=queue.remove();
				list.add(t);
				if(first==false) length=northwest.length;
				for(int i=0;i<length;i++){
					first=false;
					 x= t.getLocation().getX() + dx[northwest[i]];
					 y= t.getLocation().getY() + dy[northwest[i]];
				if(!visited[x][y]){  
					//System.out.println("x: " + x + " y: " + y);
					if(x<map.getWidth()/Scaling.TILE_WIDTH && y<map.getHeight()/Scaling.TILE_HEIGHT){
					source= map.getTile(new Point(x,y));
					if(initX-x==initY-y) r=initX-x+1;
					else r=Math.max(initX-x,initY-y);
					queue.add(new InfluenceTile(source,r));
					visited[x][y]=true;
					}
				}
				}
				curr++;
			}
		case 8: 
			if(y-1>=0){
				source=map.getTile(new Point(x,y-1));
				queue.add(new InfluenceTile(source,curr));
			}
			while(!queue.isEmpty() && curr<=check){
				InfluenceTile t=queue.remove();
				list.add(t);
				for(int i=0;i<east.length;i++){
					 x= t.getLocation().getX() + dx[north[i]];
					 y= t.getLocation().getY() + dy[north[i]];
				if(!visited[x][y]){  
					//System.out.println("x: " + x + " y: " + y);
					if(x<map.getWidth()/Scaling.TILE_WIDTH && y<map.getHeight()/Scaling.TILE_HEIGHT){
					source= map.getTile(new Point(x,y));
					queue.add(new InfluenceTile(source,initY-y));
					visited[x][y]=true;
					}
				}
				}
				curr++;
			}
		case 1:
			first=true;
			length=southwest.length-1;
			 r=0;
			if(x+1<map.getWidth()/Scaling.TILE_WIDTH && y-1>=0){
				source=map.getTile(new Point(x-1,y+1));
				queue.add(new InfluenceTile(source,curr));
			}
			while(!queue.isEmpty() && curr<=check-1){
				InfluenceTile t=queue.remove();
				list.add(t);
				if(first==false) length=southwest.length;
				for(int i=0;i<length;i++){
					first=false;
					 x= t.getLocation().getX() + dx[southwest[i]];
					 y= t.getLocation().getY() + dy[southwest[i]];
				if(!visited[x][y]){  
					//System.out.println("x: " + x + " y: " + y);
					if(x<map.getWidth()/Scaling.TILE_WIDTH && y<map.getHeight()/Scaling.TILE_HEIGHT){
					source= map.getTile(new Point(x,y));
					if(initX-x==y-initY) r=initX-x+1;
					else r=Math.max(initX-x,y-initY);
					queue.add(new InfluenceTile(source,r));
					visited[x][y]=true;
					}
				}
				}
				curr++;
			}
			
		}
		
		return list;
	}
	
	
}
