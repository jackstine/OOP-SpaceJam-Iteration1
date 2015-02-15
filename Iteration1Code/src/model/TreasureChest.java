package model;

import java.awt.image.BufferedImage;

public class TreasureChest extends InteractiveItem {
	private int state;
	private int reward;
	private boolean actionDone;
	
	public TreasureChest(){
		state=0;
		reward=1000;
		actionDone=false;
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
	
	public BufferedImage getImage(int scale) {
		return ItemImageProxy.getItemImage(this,state);
	}
	public BufferedImage getNewImage(int scale) {
		return ItemImageProxy.getNewItemImage(this,state);
	}
	
	public void changeState(){
		if(state==0){
			state=1;
		}
		else{
			state=0;
		}
	}
	
	public String getImagePath(){
		return "";  //not used
	}
}
