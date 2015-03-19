package utilities;
import java.util.*;

public class RandomNumberGenerator {
	public static int generateRand(int low, int high){
		Random rand = new Random();
	    int random = rand.nextInt((high - low) + 1) + low;
	    return random;
	}
	
	public static int next(int low, int high){
		return generateRand(low,high);
	}
	//will add AI random position;
}
