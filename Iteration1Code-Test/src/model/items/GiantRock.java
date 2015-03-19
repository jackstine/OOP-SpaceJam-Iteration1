package model.items;

import model.Entity.Avatar;
import model.visitor.ItemVisitor;

public class GiantRock extends ObstacleItem {

	public GiantRock(){
		this.ITEM_NAME = "Giant Rock";
	}

	public void accept(ItemVisitor visitor){
		visitor.accept(this);
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
