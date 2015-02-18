package model;

public class GiantRock extends ObstacleItem {
	private final String GIANT_ROCK_IMAGE = "src/res/img/giant_rock.png";

	public GiantRock(){
		this.ITEM_IMAGE = GIANT_ROCK_IMAGE;
		this.ITEM_NAME = "Giant Rock";
	}

	@Override
	public String getImagePath() {
		// TODO Auto-generated method stub
		return this.ITEM_IMAGE;
	}

	@Override
	public boolean action(Avatar avatar) {
		//Avatar does nothing since it can't pass
		return true;
	}	
	
	public String toString() {
		return "Item:GiantRock";
	}
	
	public String getItemName(){
		return this.ITEM_NAME;
	}

}
