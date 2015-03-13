package model.Entity;

import model.AreaEffect;

public class Merchant extends NPC{

	
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

}
