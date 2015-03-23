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
import model.occupation.Boss;
import model.occupation.OrcTerminator;

public class BossDavid extends NPC {
	
	public BossDavid(){
		super(new Boss());
		//this.sightBehavior = new SightTrack(this);
		//sightBehavior.perform(this);
		GuardBehavior preferred = new GuardBehavior(this,5);
		BehaviorComposite engaged = new BehaviorComposite(new Attack(this));
		this.engagedState.setState(engaged);
		this.preferredState.setState(preferred);
		this.name = "David";
	}
	
	public String toString() {
		return "NPC:David";
	}
	
	public String getDialogue() {
		return "David: Plebeian! I will destroy you!";
	}
	
	public void makeDeathSoundEffect() {
		SoundEffect effect = new DarthVaderNoooooSoundEffect();
	}
	
}
