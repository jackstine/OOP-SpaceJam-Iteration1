package model.entity;

import utilities.SpriteSheetUtility;
import model.behavior.PickPockit;

public class Skeleton extends NPC implements Conversable {
	
	public Skeleton() {
		super();
		this.engagedState.setState(new PickPockit());
	}
	
	public SpriteSheetUtility getSpriteSheet() {
		return new SpriteSheetUtility(this);
	}

	@Override
	public String getDialogue() {
		// TODO Auto-generated method stub
		return "Skeleton: I'M A SCARY SKELETON RAAWWRRR";
	}
	
	public String toString() {
		return "NPC:Skeleton";
	}

}
