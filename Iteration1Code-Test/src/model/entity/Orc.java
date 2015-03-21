package model.entity;

import utilities.DarthVaderNoooooSoundEffect;
import utilities.DeathSoundEffect;
import utilities.SoundEffect;
import model.behavior.Attack;
import model.behavior.IdleBehavior;
import model.behavior.Patrol;
import model.behavior.Pursue;
import model.behavior.Stand;
import model.occupation.OrcTerminator;

public class Orc extends NPC {
	
	public Orc(){
		super(new OrcTerminator());
		this.engagedState.setState(new Pursue(this));
		this.preferredState.setState(new Patrol(this,2));
	}
	
	public String toString() {
		return "an Orc";
	}

	public void makeDeathSoundEffect() {
		SoundEffect effect = new DarthVaderNoooooSoundEffect();
	}
	
}
