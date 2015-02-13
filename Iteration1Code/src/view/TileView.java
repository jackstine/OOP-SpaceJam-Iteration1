import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*

TileView Class
Contains an instance of a Tile, an ItemView, and an EntityView
Tile contents populate all views, and a tile is prepped to be painted

*/

public class TileView {
	
	private Tile tile;
	private ItemView item;
	private EntityView entity;
	
	public TileView(Tile t) {
		tile = t;
		
		//item = new ItemView(tile.getItem());
		//entity = new EntityView(tile.getEntity());
	}

}