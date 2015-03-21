package model.entity;

import model.behavior.Attack;
import model.behavior.Patrol;
import model.occupation.SkeletonAlchemist;

public class Skeleton extends NPC implements Conversable {
	
	public Skeleton() {
		super(new SkeletonAlchemist());
		this.engagedState.setState(new Attack(this));
		this.preferredState.setState(new Patrol(this));
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
	}

}
