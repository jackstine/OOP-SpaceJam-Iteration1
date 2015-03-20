package model.entity;

import utilities.SpriteSheetUtility;
import model.NpcEffectHandler;
import model.behavior.Attack;

public class Orc extends NPC {
	
	public Orc(){
		super();
		this.engagedState.setState(new Attack());
	}
	
	public SpriteSheetUtility getSpriteSheet() {
		return new SpriteSheetUtility(this);
	}
	
	public String toString() {
		return "NPC:Orc";
	}
	
}
