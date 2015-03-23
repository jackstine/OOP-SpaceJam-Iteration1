package model.occupation;

import model.visitor.OccupationVisitor;
import utilities.GoatSpriteSheetUtility;
import utilities.SpriteSheetUtility;

public class AvatarTerminator extends Terminator{

	public SpriteSheetUtility getSpriteSheet() {
		return new SpriteSheetUtility(this);
	}


}
