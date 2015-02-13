package view;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import javax.swing.*;

import model.Item;
import model.Tile;

/*

ItemView Class
Contains an instance of an Item to be rendered as part of a Tile

*/

public class ItemView {

	private Item item;
	private Tile tile;
	
	public ItemView(Item i) {
		item = i;
	}
	
	/*public BufferedImage getImage() {
		return item.getImage();
	}*/

}