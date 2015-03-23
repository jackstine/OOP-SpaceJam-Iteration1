package model.occupation;

import model.visitor.OccupationVisitor;
import utilities.SpriteSheetUtility;
import utilities.StealthSpriteSheetUtility;

public class AvatarHunter extends Hunter{

	public SpriteSheetUtility getSpriteSheet() {
		return new SpriteSheetUtility(this);
	}
	
	public SpriteSheetUtility engageStealth() {
		return new StealthSpriteSheetUtility(this);
	}

	

}
