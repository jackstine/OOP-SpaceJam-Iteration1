package model;

import java.io.Serializable;

public class Point implements Serializable{
    protected int x;
    protected int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }
    
    public int getHeight(){
    	return this.y;
    }
    
    public int getWidth(){
    	return this.x;
    }
    
    public void setLocation(int x,int y){
    	this.x=x;
    	this.y=y;
    }
    
    public String toString(){
    	return "X:"+this.x+" Y:"+this.y;
    }
}
