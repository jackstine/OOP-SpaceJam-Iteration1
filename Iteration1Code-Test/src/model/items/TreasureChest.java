package model.items;

import model.Avatar;
import model.visitor.ItemVisitor;

public class TreasureChest extends InteractiveItem {
	private int state;
	private int reward;
	private boolean actionDone;
	
	
	public TreasureChest(){
		state=0;
		reward=1000;
		actionDone=false;
		ITEM_NAME = "Treasure Chest";
	}
	
	public void accept(ItemVisitor visitor){
		visitor.accept(this);
	}
	
	public boolean action(Avatar avatar) {
		if(actionDone==false){
		int currentXP= avatar.getStatValue("Experience");
		avatar.setStatValue("Experience",currentXP+reward);
		actionDone=true;
		changeState();
		return true;
		}
		changeState();
		return false;
	}
	
	public void changeState(){
		if(state==0){
			state=1;
		}
		else{
			state=0;
		}
	}
	
	//probably needs to be in the InteractiveItem Abstract Class
	public int getState(){
		return this.state;
	}
	
	public String toString() {
		return "Item:TreasureChest:" + this.actionDone;
	}

	@Override
	public String getItemName() {
		return this.ITEM_NAME;
	}
	
	public void setActionDone() {
		this.actionDone = true;
	}
}
