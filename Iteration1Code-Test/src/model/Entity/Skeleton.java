package model.entity;

import java.util.Random;

import utilities.SpriteSheetUtility;

import model.NpcEffectHandler;

public class Skeleton extends NPC implements Conversable {
	
	public Skeleton() {
		super();
	}
	
	public SpriteSheetUtility getSpriteSheet() {
		return new SpriteSheetUtility(this);
	}

	@Override
	public String getDialogue() {
		// TODO Auto-generated method stub
		return "Skeleton: I'M A SCARY SKELETON RAAWWRRR";
	}
	
	@Override
	public void engage(Avatar avatar) {
		NpcEffectHandler.apply(avatar, this);
	}
	
	public String toString() {
		return "NPC:Skeleton";
	}

}
