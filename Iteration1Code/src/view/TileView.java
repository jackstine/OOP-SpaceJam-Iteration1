package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

import utilities.ImageProcessing;
import utilities.Scaling;
import model.Tile;


public class TileView extends JComponent{
	public static final int SCALE = Scaling.TILE_SCALE.getX();
	private Tile tile;
	private BufferedImage image;
	
	public TileView(Tile tile) {
		this.tile = tile;
		this.image = this.updateImage();
	}
    private BufferedImage updateImage(){
        BufferedImage imageOfTerrain = tile.getTerrain().getImage();
        BufferedImage itemImage,imageToDisplay, decalImage; //added decalImage
        if (tile.getItem() != null){
                // Assuming that the Tile WIDTH is equal to the HEIGHT
                itemImage = tile.getItem().getImage(Scaling.TILE_WIDTH-Scaling.TILE_OVERLAY_IMAGE_OFFSET);
                imageOfTerrain = tile.getTerrain().getNewImage();
                imageToDisplay = ImageProcessing.overlayImagesBottomLeftCorner(imageOfTerrain,itemImage);
        }
        if(tile.getDecal()!=null){
                decalImage = tile.getDecal().getImage(Scaling.TILE_WIDTH-Scaling.TILE_OVERLAY_IMAGE_OFFSET);
                imageOfTerrain = tile.getTerrain().getNewImage();
                imageToDisplay = ImageProcessing.overlayImagesBottomLeftCorner(imageOfTerrain,decalImage);
        }
        else{
                imageToDisplay = imageOfTerrain;
        }
        return imageToDisplay;
    }
	
	public void paintComponent(Graphics g){
        int x= tile.getLocation().getX();
        int y= tile.getLocation().getY();
        g.drawImage(this.image,Scaling.TILE_WIDTH*x+tile.getDeltaX(),Scaling.TILE_HEIGHT*y+tile.getDeltaY(), null );
        repaint();
	}
	
	
	public Dimension getPreferredSize(){
		return new Dimension(Scaling.TILE_WIDTH,Scaling.TILE_HEIGHT);
	}
	
	public String toString(){
		return this.tile.toString();
	}
}
