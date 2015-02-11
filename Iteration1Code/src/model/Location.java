package model;

public class Location extends Point{

	public Location(int x,int y){
		super(x,y);
	}
	public void add(int x,int y){
		this.x=this.x+x;
		this.y=this.y+y;
		
	}
	
	public String toString()
	{
		return this.x+"  "+this.y;
	}

}
