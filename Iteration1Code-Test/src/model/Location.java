package model;


public class Location extends Point{

	public Location(int x,int y){
		super(x,y);
	}
	
	public Location(Point point){
		super(point);
	}
	
	
	public void add(int x,int y){
		this.x += x;
		this.y += y;
	}
	
	public String toString(){
		return "Location:" + this.x + "," + this.y;
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
	
	public Location addLocation(Point point) {
		this.x += point.getX();
		this.y += point.getY();
		return this;
	}
	
	

}
