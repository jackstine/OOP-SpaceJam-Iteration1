package model.entity;

import utilities.DarthVaderNoooooSoundEffect;
import utilities.DeathSoundEffect;
import utilities.SoundEffect;
import model.behavior.Attack;
import model.behavior.BehaviorComposite;
import model.behavior.GuardBehavior;
import model.behavior.IdleBehavior;
import model.behavior.Patrol;
import model.behavior.Pursue;
import model.behavior.SightTrack;
import model.behavior.Stand;
import model.behavior.State;
import model.occupation.OrcTerminator;

public class Orc extends NPC {
	
	public Orc(){
		super(new OrcTerminator());
		//this.sightBehavior = new SightTrack(this);
		//sightBehavior.perform(this);
		GuardBehavior preferred = new GuardBehavior(this, 2);
		BehaviorComposite engaged = new BehaviorComposite(new Attack(this));
		this.engagedState.setState(engaged);
		this.preferredState.setState(preferred);
		this.name = "Orc";
	}
	
	public String toString() {
		return "NPC:Orc";
	}
	
	public String getDialogue() {
		return "Orc: Stop clicking me!";
	}
	
	public void makeDeathSoundEffect() {
		SoundEffect effect = new DeathSoundEffect();
	}
	
}
