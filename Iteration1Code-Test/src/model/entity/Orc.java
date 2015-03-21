package model.entity;

import model.behavior.Attack;
import model.behavior.Patrol;
import model.occupation.OrcTerminator;

public class Orc extends NPC {
	
	public Orc(){
		super(new OrcTerminator());
		this.engagedState.setState(new Attack(this));
		this.preferredState.setState(new Patrol(this));
	}
	
	public String toString() {
		return name+"NPC:Orc";
	}

	public void makeDeathSoundEffect() {
	}
	
}
