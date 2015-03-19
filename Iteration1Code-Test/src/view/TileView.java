package view;
 
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;
 








import utilities.ImageProcessing;
import utilities.Scaling;
import model.TerrainImageVisitor;
import model.Tile;
import model.entity.NPC;
import model.visitor.ItemImageVisitor;
 
@SuppressWarnings("serial")
public class TileView extends JComponent{
    public static final int SCALE = Scaling.TILE_SCALE.getX();
    private Tile tile;
    private BufferedImage image;
    private static final TerrainImageVisitor terrainVisitor = new TerrainImageVisitor(Scaling.TILE_SCALE);
    //NOTE This is static because TileView will always be the same with each TileView
    private static final ItemImageVisitor itemVisitor = new ItemImageVisitor(Scaling.TILE_TAKEABLE_ITEM_OFFSET);
   
    public TileView(Tile tile) {
            this.tile = tile;
            this.image = this.updateImage();
    }
    
    //updates the Tile Image with Items, or Decals
    private BufferedImage updateImage(){
        this.tile.getTerrain().accept(terrainVisitor);
        BufferedImage imageOfTerrain = terrainVisitor.getImage();
        BufferedImage itemImage,imageToDisplay, decalImage, trapImage, NPCimage; //added decalImage
        
        // Could use a ENUM here 
        if (tile.getItem() != null){
                // Assuming that the Tile WIDTH is equal to the HEIGHT
                tile.getItem().accept(itemVisitor);
                itemImage = itemVisitor.getImage();
                imageOfTerrain = ImageProcessing.createNewImage(imageOfTerrain);
                imageToDisplay = ImageProcessing.overlayImagesBottomLeftCorner(imageOfTerrain,itemImage);
        }
        if(tile.getDecal()!=null){
                decalImage = tile.getDecal().getImage(Scaling.TILE_WIDTH-Scaling.TILE_OVERLAY_IMAGE_OFFSET);
                imageOfTerrain = ImageProcessing.createNewImage(imageOfTerrain);
                imageToDisplay = ImageProcessing.overlayImagesBottomLeftCorner(imageOfTerrain,decalImage);
        }
        if(tile.getTrap()!=null){
        	trapImage= tile.getTrap().getImage(); 
        	if (trapImage != null){
        		imageOfTerrain = ImageProcessing.createNewImage(imageOfTerrain);
        		imageToDisplay = ImageProcessing.overlayImagesBottomLeftCorner(imageOfTerrain,trapImage);
        	}
        }
        if(tile.getNPC()!=null){
        //	tile.getNPC().accept(itemVisitor);
        	
        	NPCimage= tile.getNPC().getImage(); //need to add a proxy for this
        	imageOfTerrain = ImageProcessing.createNewImage(imageOfTerrain);
            imageToDisplay = ImageProcessing.overlayImagesBottomLeftCorner(imageOfTerrain,NPCimage);
        }
        else{
                imageToDisplay = imageOfTerrain;
        }
        return imageToDisplay;
    }
      
    // xTile and yTile are the offsets of tile spaces on a Map  (not pixels)
    public void paintComponent(Graphics g, int xTile, int yTile){
        int x= tile.getLocation().getX() - xTile;
        int y= tile.getLocation().getY() - yTile;
        g.drawImage(this.image, x*Scaling.TILE_WIDTH ,y*Scaling.TILE_HEIGHT , null );
    }
       
    public Dimension getPreferredSize(){
            return new Dimension(Scaling.TILE_WIDTH,Scaling.TILE_HEIGHT);
    }
   
    public String toString(){
            return this.tile.toString();
    }
}