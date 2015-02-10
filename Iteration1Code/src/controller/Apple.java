package controller;

import java.io.Serializable;

public class Apple implements Serializable {
	public String s;
	public Apple(){
		s = "new";
	}
	public Apple(String s){
		this.s = s;
	}
}
