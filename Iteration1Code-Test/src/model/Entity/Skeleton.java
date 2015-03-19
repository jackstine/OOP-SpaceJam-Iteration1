package model.Entity;

import java.util.Random;

import utilities.SpriteSheetUtility;

import model.AreaEffect;
import model.NpcEffectHandler;

public class Skeleton extends NPC implements Conversable {
	protected AreaEffect effect;
	
	public Skeleton(AreaEffect effect) {
		super();
		this.effect=effect;
	}
	
	public SpriteSheetUtility getSpriteSheet() {
		return new SpriteSheetUtility(this);
	}
	
	public int randNo()
	{
		int x;
		Random rand=new Random();
		x=rand.nextInt();
		return x;
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

}
