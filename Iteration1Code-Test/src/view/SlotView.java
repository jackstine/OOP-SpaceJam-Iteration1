package view;


import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import utilities.ImageProcessing;
import utilities.Scaling;
import model.Point;
import model.slots.InventorySlot;
import model.visitor.ItemImageVisitor;


@SuppressWarnings("serial")
public class SlotView extends JPanel implements Observer{
	private static final int SLOTIMAGE_HEIGHT = Scaling.SLOT_VIEW_HEIGHT;
	private static final int SLOTIMAGE_WIDTH = Scaling.SLOT_VIEW_WIDTH;
	private static final Point SLOT_SCALE = new Point(SLOTIMAGE_WIDTH,SLOTIMAGE_HEIGHT);

	private final String INVENTORY_IMAGE = "src/res/img/brown-InventorySlot.png";
	
	private static ItemImageVisitor itemVisitor = new ItemImageVisitor(SLOT_SCALE);
	
	private Point point;
	private BufferedImage slotImage;
	private InventorySlot slot;
	private BufferedImage itemImage;
	private InventoryView inventoryView;
	
	public SlotView(InventorySlot slot,Point pointOfSlot, InventoryView inventoryView){
		this.inventoryView = inventoryView;
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
			this.slot.get().accept(itemVisitor);
			this.itemImage = itemVisitor.getImage();
		}
	}
	
	public void paintComponent(Graphics g){
		// the point is refactored with the Width and Height, 
		//  they fill in their respective Grid
		//  each point is a fill for a Grid
		int heightLocation = this.point.getX() * SLOTIMAGE_HEIGHT;
		int widthLocation =  this.point.getY() * SLOTIMAGE_WIDTH;
		g.drawImage(this.slotImage, widthLocation , heightLocation , null);
	}
	
	//Dave said not to query the model in the view
	//so prop make a controller to set the image
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
	
	//just resets the image according to the inventorySlot
	public void update(Observable arg0, Object arg1) {
		System.out.println("REPAINTING THE ITEM");
		this.resetImage();
		this.repaint();
		this.inventoryView.repaint();
	}
}
