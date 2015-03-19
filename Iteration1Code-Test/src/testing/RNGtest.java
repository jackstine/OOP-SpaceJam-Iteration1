package testing;

import model.Point;
import utilities.RNG;

public class RNGtest {
	public static void main(String[] args){
		Point p= RNG.AInext();
		System.out.println(p.toString());
	}
}
