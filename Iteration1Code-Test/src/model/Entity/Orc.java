package model.Entity;

import utilities.SpriteSheetUtility;
import model.NpcEffectHandler;

public class Orc extends NPC {
	protected int hp=100;
	
	public Orc(){
		super();
	}

	public String toString(){
		return "I AM AN ORC";
	}
	
	public SpriteSheetUtility getSpriteSheet() {
		return new SpriteSheetUtility(this);
	}

	@Override
	public void engage(Avatar avatar) {
		NpcEffectHandler.apply(avatar, this);
	}
	
}
