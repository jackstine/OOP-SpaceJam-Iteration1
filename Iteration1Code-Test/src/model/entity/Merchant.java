package model.entity;

import utilities.FriendlyDeathSoundEffect;
import utilities.SoundEffect;
import model.behavior.Barter;
import model.behavior.Patrol;
import model.behavior.Stand;
import model.occupation.MerchantHunter;

public class Merchant extends NPC {
	
	public Merchant() {
		super(new MerchantHunter());
		this.name = "Merchant";
		this.engagedState.setState(new Barter(this));
		this.preferredState.setState(new Stand(this));
		//SoundEffect effect = new FriendlyDeathSoundEffect();
	}

	@Override
	public String getDialogue() {
		// TODO Auto-generated method stub
		return "Merchant: Hey there! Have a look at my wares.";
	}
	
	public String toString() {
		return "NPC:Merchant";
	}
	
	@Override
	public void makeDeathSoundEffect(){
		soundEffect = new FriendlyDeathSoundEffect();
	}

}
