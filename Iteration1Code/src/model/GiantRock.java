package model;

import java.awt.image.BufferedImage;

public class GiantRock extends ObstacleItem {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2978480808211942348L;

	public GiantRock(){
		this.ITEM_IMAGE = "src/res/img/giant_rock.png";
	}

	@Override
	public String getImagePath() {
		// TODO Auto-generated method stub
		return this.ITEM_IMAGE;
	}

	@Override
	public boolean action(Avatar avatar) {
		//Avatar does nothing since it can't pass
		return false;
	}

	public void action(Entity entity) {
		// TODO Auto-generated method stub
		
	}

	
	

}
