package view;
 
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;
 

import utilities.ImageProcessing;
import utilities.Scaling;
import model.ItemImageVisitor;
import model.TerrainImageVisitor;
import model.Tile;
 
public class TileView extends JComponent{
    public static final int SCALE = Scaling.TILE_SCALE.getX();
    private Tile tile;
    private BufferedImage image;
    private TerrainImageVisitor terrainVisitor = new TerrainImageVisitor();
    private ItemImageVisitor itemVisitor = new ItemImageVisitor();
   
    public TileView(Tile tile) {
            this.tile = tile;
            this.image = this.updateImage();
    }
    
    //updates the Tile Image with Items, or Decals
    private BufferedImage updateImage(){
        this.tile.getTerrain().accept(terrainVisitor);
        BufferedImage imageOfTerrain = terrainVisitor.getImage();
        BufferedImage itemImage,imageToDisplay, decalImage; //added decalImage
        
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