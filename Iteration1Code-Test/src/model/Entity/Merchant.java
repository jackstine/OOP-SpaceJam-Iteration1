package model.entity;

import utilities.Scaling;
import utilities.SpriteSheetUtility;
import view.MerchantView;
import model.NpcEffectHandler;

public class Merchant extends NPC implements Conversable {
	private MerchantView mvc;
	
	public Merchant() {
		super();
		this.mvc=new MerchantView();
		mvc.setBounds(Scaling.MERCHANTVIEW_X , Scaling.MERCHANTVIEW_Y, Scaling.MERCHANTVIEW_WIDTH, Scaling.MERCHANTVIEW_HEIGHT);
	}
	
	public SpriteSheetUtility getSpriteSheet() {
		return new SpriteSheetUtility(this);
	}

	public String getDialogue() {
		// TODO Auto-generated method stub
		return "Merchant: Hey there! Have a look at my wares.";
	}
	
	public void engage(Avatar avatar) {
		mvc.setAvatar(avatar);
		NpcEffectHandler.apply(avatar, this);
	}
	
	public String toString() {
		return "NPC:Merchant";
	}
	public MerchantView getMerchantView(){
		return this.mvc;
	}

}
