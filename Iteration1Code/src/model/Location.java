package model;

public class Location extends Point{

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
	
	

}
