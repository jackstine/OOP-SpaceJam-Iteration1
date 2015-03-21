package model.entity;

import java.awt.image.BufferedImage;

import model.occupation.*;
import utilities.*;

public abstract class NPC extends Entity {
	private BufferedImage image;
	
	public NPC(Occupation oc) {
		super(oc);

		setDirection(2);
		//this.location = new Location(INITIAL_X_LIE, INITIAL_Y_LIE);
	}
}
