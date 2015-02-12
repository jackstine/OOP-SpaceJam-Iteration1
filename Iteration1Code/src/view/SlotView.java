package view;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import utilities.ImageProcessing;
import model.InventorySlot;
import model.Item;
import model.Point;
import model.Slotable;
import model.Weapon;


public class SlotView extends Component implements Observer{
	public static final int SLOTIMAGE_HEIGHT = 50;
	public static final int SLOTIMAGE_WIDTH = 50;
	public static final int ITEM_IMAGE_HEIGHT = (3*SLOTIMAGE_HEIGHT)/4;
	public static final int ITEM_IMAGE_WIDTH = (3*SLOTIMAGE_WIDTH)/4;
	public static final int ITEM_IMAGE_SCALE = (ITEM_IMAGE_HEIGHT + ITEM_IMAGE_WIDTH) /2;
	
	private final String WEAPON_IMAGE = "src/res/img/weapon.png";
	private final String INVENTORY_IMAGE = "src/res/img/brown-InventorySlot.png";

	private static final long serialVersionUID = 15475L;
	
	private Point pointOnView;					// this is the point that it generates on the view
												//for SlotView it is the same as the InventoryView PointOnView
												// it is used to reference the Point at which to draw the Inventory
												// likewise the slots for the inventory
	private Point point;
	private BufferedImage slotImage;
	private Slotable<Item> slot;
	private BufferedImage itemImage;
	
	//TODO not sure if Slot should be referenced inside the SlotView, or just the point reference to it
	
	public SlotView(Slotable<Item> slot){
		this.slot = slot;
		this.setImages();
		this.point= new Point(0,0);
	}
	
	public SlotView(Slotable<Item> slot,Point pointOfSlot,Point pointOnView){
		this.pointOnView = pointOnView;
		this.slot = slot;
		this.setImages();
		this.point= pointOfSlot;
	}
	
	public void setPointOnView(Point point){
		this.pointOnView = point;
	}
	
	public Point getPointOnView(){
		return this.pointOnView;
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
	
	public void paint(Graphics g){
		// the point is refractored with the Width and Height, 
		//  they fill in their respective Grid
		//  each point is a fill for a Grid
		int heightLocation = this.point.getX() * SLOTIMAGE_HEIGHT + pointOnView.getY();
		int widthLocation =  this.point.getY() * SLOTIMAGE_WIDTH + pointOnView.getX();
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
	
    public static void main(String[] args) {

        JFrame f = new JFrame("Load Image Sample");
        f.addWindowListener(new WindowAdapter(){
	        public void windowClosing(WindowEvent e) {
	            System.exit(0);
	        }
        });
        InventorySlot slot = new InventorySlot();
        Weapon weapon = new Weapon(10);
        slot.equip(weapon);
        SlotView slotView = new SlotView(slot);
        slotView.resetImage();					//TODO make this automatic
        f.add(slotView);
        f.pack();
        f.setVisible(true);
    }
}
