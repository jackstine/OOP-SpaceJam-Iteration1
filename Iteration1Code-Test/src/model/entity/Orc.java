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
	
	public String toString() {
		return "NPC:Orc";
	}
	
}
