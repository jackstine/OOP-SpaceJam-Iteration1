package model.entity;

import utilities.SpriteSheetUtility;
import model.NpcEffectHandler;

public class Merchant extends NPC implements Conversable {

	
	public Merchant() {
		super();
	}
	
	public String toString(){
		return "I am a MERCHANT I SELL>>>>";
	}
	
	public SpriteSheetUtility getSpriteSheet() {
		return new SpriteSheetUtility(this);
	}

	public String getDialogue() {
		// TODO Auto-generated method stub
		return "Merchant: Hey there! Have a look at my wares.";
	}
	
	public void engage(Avatar avatar) {
		NpcEffectHandler.apply(avatar, this);
	}

}
