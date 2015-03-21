package model.occupation;

import utilities.SpriteSheetUtility;

public class AvatarHunter extends Hunter{

	public SpriteSheetUtility getSpriteSheet() {
		return new SpriteSheetUtility(this);
	}
}
