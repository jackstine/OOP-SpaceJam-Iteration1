package model;

import java.awt.image.BufferedImage;

public interface Item {
	public boolean action(Avatar avatar);

	public BufferedImage getImage(int scale);
}
