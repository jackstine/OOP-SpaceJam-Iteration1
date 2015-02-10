package view;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import 

import model.Point;


public class SlotView {
	private Point point;
	private Image slotImage;
	
	SlotView() throws IOException{
		this.slotImage = ImageIO.read(new File("res.img/brown-InventorySlot.png"));
	}
	
	boolean Graphics.drawIamge(Image slotImage, int x,int y);

}
