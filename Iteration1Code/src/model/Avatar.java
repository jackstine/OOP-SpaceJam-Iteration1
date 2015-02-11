package model;

import controller.MapViewController;

public class Avatar extends Entity{
	private InventoryContainer inventory;
	private Location location;
	private final int INITIAL_X = 0;
	private final int INITIAL_Y =0;
	
	public Avatar() {
		this.location = new Location(INITIAL_X,INITIAL_Y);
		//occupation.initializeStats();
	}
	public void move(int x,int y){
	location.add(x,y);
	System.out.println(location);
	}
	
	/*
	//private void attack() {
	//	
	//}
	//may not need to override
	 */
	
	/*
	//private void useAbility() {
	//	
	//}
	//may not need to override
	 */
	
	
}
