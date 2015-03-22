package model.occupation;

import model.visitor.OccupationVisitor;
import utilities.SpriteSheetUtility;

public class AvatarHunter extends Hunter{

	public SpriteSheetUtility getSpriteSheet() {
		return new SpriteSheetUtility(this);
	}

}
