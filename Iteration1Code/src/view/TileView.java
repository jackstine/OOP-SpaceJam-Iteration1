package view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import utilities.ImageProcessing;
import utilities.Scaling;
import model.Location;
import model.Tile;


public class TileView extends JPanel{
	public static final int SCALE = Scaling.TILE_SCALE.getX();
	private final int OVERLAY_IMAGE_OFFSET = Scaling.TILE_OVERLAY_IMAGE_OFFSET;
	
	private Tile tile;
	private ItemView item;
	
	public TileView(Tile tile) {
		this.tile = tile;
	}
	
	private BufferedImage updateImage(){
		BufferedImage imageOfTerrain = tile.getTerrain().getImage();
		BufferedImage itemImage,imageToDisplay;
		//if (item != null){
		//	itemImage = item.getImage(SCALE-OVERLAY_IMAGE_OFFSET);
		//	imageToDisplay = ImageProcessing.overlayImagesBottomLeftCorner(imageOfTerrain, itemImage);
		//}
		//else{
			imageToDisplay = imageOfTerrain;
		//}
		return imageToDisplay;
	}
	
	public void draw(Graphics g){
		//if has Item overlay
		BufferedImage imageToDisplay = this.updateImage();
		//System.out.println(this+imageToDisplay.toString());
		
		//Map must be imported in order for this to work
		//g.drawImage(imageToDisplay,SCALE*x+map.deltaX,SCALE*y+deltaY,null);
	}

}