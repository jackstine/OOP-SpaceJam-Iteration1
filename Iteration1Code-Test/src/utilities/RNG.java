package utilities;
import java.util.*;

import model.Point;

public class RNG {
	private static int generateRand(int low, int high){
		Random rand = new Random();
	    int random = rand.nextInt((high - low) + 1) + low;
	    return random;
	}
	
	public static int next(int high){
		return generateRand(0,high);
	}
	
	public static int next(int low, int high){
		return generateRand(low,high);
	}
	
	public static Point AInext(){
		int low=-1;
		int high=1;
		int xPos= generateRand(low,high);
		int yPos= generateRand(low,high);
		return new Point(xPos,yPos);
	}
}
