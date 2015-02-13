package model;

import java.io.Serializable;

public class Location extends Point implements Serializable{

	public Location(int x,int y){
		super(x,y);
	}
	public void add(int x,int y){
		this.x += x;
		this.y += y;
	}
	
	public String toString(){
		return this.x+"  "+this.y;
	}
	public void add(Point point) {  
		this.x += point.getX();
		this.y += point.getY();
	}
	
	public Location addLocation(int x, int y){
		this.x+=x;
		this.y+=y;
		return this;
	}
	
	

}
