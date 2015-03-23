package model.entity;

import utilities.DarthVaderNoooooSoundEffect;
import utilities.DeathSoundEffect;
import utilities.SoundEffect;
import model.behavior.Attack;
import model.behavior.BehaviorComposite;
import model.behavior.IdleBehavior;
import model.behavior.Patrol;
import model.behavior.Pursue;
import model.behavior.RangeTrack;
import model.behavior.SightTrack;
import model.behavior.Stand;
import model.behavior.State;
import model.occupation.OrcTerminator;

public class Orc extends NPC {
	
	public Orc(){
		super(new OrcTerminator());
		
		//this.sightBehavior = new SightTrack(this);
		//sightBehavior.perform(this);
		BehaviorComposite preferred = new BehaviorComposite(new Patrol(this,2), new Pursue(this));
		BehaviorComposite engaged = new BehaviorComposite(new Attack(this));
		this.engagedState.setState(engaged);
		this.preferredState.setState(preferred);
	}
	
	public String toString() {
		return "an Orc";
	}
	
	public void makeDeathSoundEffect() {
		SoundEffect effect = new DarthVaderNoooooSoundEffect();
	}
	
}
