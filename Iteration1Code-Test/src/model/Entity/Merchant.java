package model.Entity;

import model.AreaEffect;

public class Merchant extends NPC implements Conversable {

	
	public Merchant() {
		super("Merchant");
		// TODO Auto-generated constructor stub
	}
	
	public String toString(){
		return "I am a MERCHANT I SELL>>>>";
	}

	@Override
	public AreaEffect getAreaEffect() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDialogue() {
		// TODO Auto-generated method stub
		return "Merchant: Hey there! Have a look at my wares. \n";
	}

}
