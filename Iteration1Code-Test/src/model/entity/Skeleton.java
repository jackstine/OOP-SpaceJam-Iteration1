package model.entity;

import utilities.DeathSoundEffect;
import utilities.SoundEffect;
import model.behavior.Attack;
import model.behavior.BehaviorComposite;
import model.behavior.IdleBehavior;
import model.behavior.Patrol;
import model.behavior.Stand;
import model.occupation.SkeletonAlchemist;

public class Skeleton extends NPC {
	
	public Skeleton() {
		super(new SkeletonAlchemist());
		this.engagedState.setState(new BehaviorComposite(new Attack(this)));
		this.preferredState.setState(new BehaviorComposite(new Stand(this)));
		this.name = "Skeleton";
	}

	@Override
	public String getDialogue() {
		// TODO Auto-generated method stub
		return "Skeleton: I'M A SCARY SKELETON RAAWWRRR";
	}
	
	public String toString() {
		return "NPC:Skeleton";
	}

	public void makeDeathSoundEffect() {
		SoundEffect effect = new DeathSoundEffect();
	}

}
