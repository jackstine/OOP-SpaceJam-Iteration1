package model.entity;

import model.occupation.Occupation;
import utilities.SpriteSheetUtility;

public class Neutral extends NPC{

	public Neutral(Occupation oc) {
		super(oc);
		
	}

	@Override
	public void engage(Entity entity) {
		// TODO Auto-generated method stub
		
	}

	public void makeDeathSoundEffect() {
	}

}
