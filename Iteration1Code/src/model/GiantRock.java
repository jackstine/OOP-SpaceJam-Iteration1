package model;

import java.awt.image.BufferedImage;


public class GiantRock extends ObstacleItem {
	private final String GIANT_ROCK_IMAGE = "src/res/img/giant_rock.png";
	private static final long serialVersionUID = -2978480808211942348L;

	public GiantRock(){
		this.ITEM_IMAGE = GIANT_ROCK_IMAGE;
	}

	@Override
	public String getImagePath() {
		// TODO Auto-generated method stub
		return this.ITEM_IMAGE;
	}

	@Override
	public boolean action(Avatar avatar) {
		//Avatar does nothing since it can't pass
		return true;
	}	

}
