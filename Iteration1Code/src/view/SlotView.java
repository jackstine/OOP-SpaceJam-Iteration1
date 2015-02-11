package view;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.*;

import utilities.ImageProcessing;
import model.InventorySlot;
import model.Item;
import model.Point;
import model.Slotable;
import model.Weapon;


public class SlotView extends Component{

	private static final long serialVersionUID = 1555L;
	private Point point;
	private BufferedImage slotImage;
	private Slotable<Item> slot;
	private BufferedImage itemImage;
	private String weaponImage = "weapon.png";
	private String inventoryImage = "brown-InventorySlot.png";
	private final int SLOTIMAGE_HEIGHT = 50;
	private final int SLOTIMAGE_WIDTH = 50;
	private final int ITEMIMAGE_HEIGHT = (3*SLOTIMAGE_HEIGHT)/4;
	private final int ITEMIMAGE_WIDTH = (3*SLOTIMAGE_WIDTH)/4;
	
	public SlotView(Slotable<Item> slot){
		this.slot = slot;
		this.setSlotImage();
		this.point= new Point(0,0);
	}
	
	public void setSlotImage() {
		this.slotImage = ImageProcessing.scaleImage(SLOTIMAGE_HEIGHT,SLOTIMAGE_WIDTH,inventoryImage);
	}
	
	public void setItemImage(){
			this.itemImage = ImageProcessing.scaleImage(ITEMIMAGE_HEIGHT, ITEMIMAGE_WIDTH, weaponImage);
	}
	
	public void paint(Graphics g){
		g.drawImage(this.slotImage, 0, 0, null);
	}
	
	private void resetImage(){
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
			this.slotImage = ImageProcessing.scaleImage(200,200,inventoryImage);
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
        slotView.resetImage();
        f.add(slotView);
        f.pack();
        f.setVisible(true);
    }

}
