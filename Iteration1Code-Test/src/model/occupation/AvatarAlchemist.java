package model.occupation;

import model.visitor.OccupationVisitor;
import utilities.SpriteSheetUtility;

public class AvatarAlchemist extends Alchemist{

	public SpriteSheetUtility getSpriteSheet() {
		return new SpriteSheetUtility(this);
	}


}
