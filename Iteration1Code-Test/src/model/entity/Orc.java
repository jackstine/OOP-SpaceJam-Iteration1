package model.entity;

import utilities.SpriteSheetUtility;
import model.NpcEffectHandler;
import model.behavior.Attack;
import model.occupation.OrcTerminator;

public class Orc extends NPC {
	

	public Orc(){
		super(new OrcTerminator());
		this.engagedState.setState(new Attack());
	}
	
	public Orc(String name){
		super(new OrcTerminator());
		this.name = name;
		this.engagedState.setState(new Attack());
	}
	
	public String toString() {
		return name+"NPC:Orc";
	}
	
}
