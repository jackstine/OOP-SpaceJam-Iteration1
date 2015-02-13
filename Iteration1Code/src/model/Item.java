package model;

import java.awt.image.BufferedImage;

public interface Item {
	public void action(Entity entity);

	public BufferedImage getImage(int scale);
	
	public String getImagePath();
}

