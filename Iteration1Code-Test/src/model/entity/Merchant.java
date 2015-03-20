package model.entity;

import utilities.Scaling;
import utilities.SpriteSheetUtility;
import view.MerchantView;
import model.NpcEffectHandler;
import model.behavior.Barter;

public class Merchant extends NPC implements Conversable {
	
	public Merchant() {
		super();
		this.engagedState.setState(new Barter());
	}
	
	public SpriteSheetUtility getSpriteSheet() {
		return new SpriteSheetUtility(this);
	}

	public String getDialogue() {
		// TODO Auto-generated method stub
		return "Merchant: Hey there! Have a look at my wares.";
	}
	
	public String toString() {
		return "NPC:Merchant";
	}

}
