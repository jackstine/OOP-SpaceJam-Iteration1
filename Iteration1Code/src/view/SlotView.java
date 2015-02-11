package view;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import utilities.ImageProcessing;
import model.InventorySlot;
import model.Item;
import model.Point;
import model.Slotable;
import model.Weapon;


public class SlotView extends Component{
	public static final int SLOTIMAGE_HEIGHT = 50;
	public static final int SLOTIMAGE_WIDTH = 50;
	public static final int ITEMIMAGE_HEIGHT = (3*SLOTIMAGE_HEIGHT)/4;
	public static final int ITEMIMAGE_WIDTH = (3*SLOTIMAGE_WIDTH)/4;
	
	private final String WEAPON_IMAGE = "src/res/img/weapon.png";
	private final String INVENTORY_IMAGE = "src/res/img/brown-InventorySlot.png";

	private static final long serialVersionUID = 15475L;
	
	private Point point;
	private BufferedImage slotImage;
	private Slotable<Item> slot;
	private BufferedImage itemImage;
	
	//TODO need to change the Slot so that it is taken care of properly in the system
	//TODO not sure if Slot should be referenced inside the SlotView, or just the point reference to it
	//TODO need to use Observable to reset the image every time the slot is equipped and unequipped
	
	public SlotView(Slotable<Item> slot){
		this.slot = slot;
		this.setSlotImage();
		this.point= new Point(0,0);
	}
	
	public SlotView(Slotable<Item> slot,Point pointOfSlot){
		this.slot = slot;
		this.setSlotImage();
		this.point= pointOfSlot;
	}
	
	public void setSlotImage() {
		try {
			this.slotImage = ImageIO.read(new File(INVENTORY_IMAGE));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.slotImage = ImageProcessing.scaleImage(SLOTIMAGE_HEIGHT,SLOTIMAGE_WIDTH,this.slotImage);
	}
	
	public void setItemImage(){
			this.itemImage = ImageProcessing.scaleImage(ITEMIMAGE_HEIGHT, ITEMIMAGE_WIDTH, this.itemImage);
	}
	
	public void paint(Graphics g){
		// the point is refractored with the Width and Height, 
		//  they fill in their respective Grid
		//  each point is a fill for a Grid
		int heightLocation = this.point.getX()*SLOTIMAGE_HEIGHT;
		int widthLocation =  this.point.getY()*SLOTIMAGE_WIDTH;
		g.drawImage(this.slotImage, widthLocation , heightLocation , null);
	}
	
	//TODO change to a automatically called and private
	public void resetImage(){
		if (this.slot.has()){
			this.setItemImage();
			try {
				this.slotImage = ImageProcessing.overlayImages(this.slotImage,this.itemImage);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{
			this.slotImage = ImageProcessing.scaleImage(SLOTIMAGE_HEIGHT,SLOTIMAGE_WIDTH,this.slotImage);
		}
	}
	
	public Dimension getPreferredSize(){
        if (this.slotImage == null) {
            return new Dimension(SLOTIMAGE_HEIGHT,SLOTIMAGE_WIDTH);
       } else {
          return new Dimension(this.slotImage.getWidth(null), slotImage.getHeight(null));
       }
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
