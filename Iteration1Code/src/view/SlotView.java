package view;


import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import utilities.ImageProcessing;
import utilities.Scaling;
import model.InventorySlot;
import model.Point;


public class SlotView extends JPanel implements Observer{
	private static final int SLOTIMAGE_HEIGHT = Scaling.SLOT_VIEW_HEIGHT;
	private static final int SLOTIMAGE_WIDTH = Scaling.SLOT_VIEW_WIDTH;
	private static final int ITEM_IMAGE_HEIGHT = (3*SLOTIMAGE_HEIGHT)/4;
	private static final int ITEM_IMAGE_WIDTH = (3*SLOTIMAGE_WIDTH)/4;
	private static final int ITEM_IMAGE_SCALE = (ITEM_IMAGE_HEIGHT + ITEM_IMAGE_WIDTH) /2;

	private final String INVENTORY_IMAGE = "src/res/img/brown-InventorySlot.png";

	private static final long serialVersionUID = 15475L;
	
	private Point point;
	private BufferedImage slotImage;
	private InventorySlot slot;
	private BufferedImage itemImage;
	
	//TODO not sure if Slot should be referenced inside the SlotView, or just the point reference to it
	
	public SlotView(InventorySlot slot){
		this.slot = slot;
		this.setImages();
		this.point= new Point(0,0);
	}
	
	public SlotView(InventorySlot slot,Point pointOfSlot){
		this.slot = slot;
		this.setImages();
		this.point= pointOfSlot;
	}
	
	public void setImages(){
		this.setSlotImage();
		this.setItemImage();
	}
	public void setSlotImage() {
		this.slotImage = ImageProcessing.scaleImage(SLOTIMAGE_WIDTH,SLOTIMAGE_HEIGHT,INVENTORY_IMAGE);
	}
	
	public void setItemImage(){
		if (slot.has()){
			this.itemImage = this.slot.get().getImage(ITEM_IMAGE_SCALE);
		}
	}
	
	public void paintComponent(Graphics g){
		// the point is refractored with the Width and Height, 
		//  they fill in their respective Grid
		//  each point is a fill for a Grid
		int heightLocation = this.point.getX() * SLOTIMAGE_HEIGHT;
		int widthLocation =  this.point.getY() * SLOTIMAGE_WIDTH;
		g.drawImage(this.slotImage, widthLocation , heightLocation , null);
	}
	
	//TODO make private method
	public void resetImage(){
		if (this.slot.has()){
			this.setImages();
			this.slotImage = ImageProcessing.overlayImages(this.slotImage,this.itemImage);
		}
		else{
			this.slotImage = ImageProcessing.scaleImage(SLOTIMAGE_WIDTH,SLOTIMAGE_HEIGHT,INVENTORY_IMAGE);
		}
	}
	
	public Dimension getPreferredSize(){
        if (this.slotImage == null) {
            return new Dimension(SLOTIMAGE_WIDTH,SLOTIMAGE_HEIGHT);
       } else {
          return new Dimension(this.slotImage.getWidth(null), slotImage.getHeight(null));
       }
	}
	
	@Override	//just resets the image according to the inventorySlot
	public void update(Observable arg0, Object arg1) {
		this.resetImage();
	}
}
