package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

import utilities.ImageProcessing;
import utilities.Scaling;
import model.ArmorSlot;
import model.BufferSlot;
import model.Equipment;
import model.Point;

public class EquipmentView extends JComponent{
	private final Point POINT_OF_WEAPON = new Point(Scaling.EQUIPMENT_WEAPON_X,Scaling.EQUIPMENT_WEAPON_Y);
	private final Point POINT_OF_ARMOR = new Point(Scaling.EQUIPMENT_ARMOR_X,Scaling.EQUIPMENT_ARMOR_Y);
	private final Point POINT_OF_HELMET = new Point(Scaling.EQUIPMENT_HELMET_X, Scaling.EQUIPMENT_HELMET_Y);
	private final Point POINT_OF_GLOVES = new Point(Scaling.EQUIPMENT_GLOVES_X, Scaling.EQUIPMENT_GLOVES_Y);
	private final Point POINT_OF_LEGGINGS = new Point(Scaling.EQUIPMENT_LEGGINGS_X, Scaling.EQUIPMENT_LEGGINGS_Y);
	private final Point POINT_OF_SHIELD = new Point(Scaling.EQUIPMENT_SHIELD_X, Scaling.EQUIPMENT_SHIELD_Y);
	private final Point POINT_OF_BOOTS = new Point(Scaling.EQUIPMENT_BOOTS_X, Scaling.EQUIPMENT_BOOTS_Y);
	private final Point SIZE_OF_SLOT = new Point(Scaling.EQUIPMENT_SLOT_WIDTH, Scaling.EQUIPMENT_SLOT_HEIGHT);
	private final Point EQUIPMENT_SLOT_OFFSET = new Point(Scaling.EQUIPMENT_SLOT_OFFSET_WIDTH,Scaling.EQUIPMENT_SLOT_OFFSET_HEIGHT);
	
	private final String EQUIPMENT_WEAPON_IMAGE_PATH = "src/res/img/Equipment_Weapon_Slot.png";
	private final String EQUIPMENT_ARMOR_IMAGE_PATH = "src/res/img/Equipment_Armor_Slot.png";
	private final String EQUIPMENT_BOOTS_IMAGE_PATH = "src/res/img/Equipment_Boots_Slot.png";
	private final String EQUIPMENT_GLOVES_IMAGE_PATH = "src/res/img/Equipment_Gloves_Slot.png";
	private final String EQUIPMENT_LEGGINGS_IMAGE_PATH = "src/res/img/Equipment_Leggings_Slot.png";
	private final String EQUIPMENT_SHIELD_IMAGE_PATH = "src/res/img/Equipment_Shield_Slot.png";
	private final String EQUIPMENT_HELMET_IMAGE_PATH = "src/res/img/Equipment_Helmet_Slot.png";
	
	
	/**************************  POINTS ON THE GRAPH,  SLOTS FOR ARRAYS   ***********************************/
	public static final Point ARMOR_POINT = new Point((Scaling.EQUIPMENT_ARMOR_X/ Scaling.EQUIPMENT_SLOT_WIDTH)
			,(Scaling.EQUIPMENT_ARMOR_Y/ Scaling.EQUIPMENT_SLOT_HEIGHT));
	public static final Point WEAPON_POINT = new Point ((Scaling.EQUIPMENT_WEAPON_X/ Scaling.EQUIPMENT_SLOT_WIDTH)
			,(Scaling.EQUIPMENT_WEAPON_Y/ Scaling.EQUIPMENT_SLOT_WIDTH));
	public static final Point HELMET_POINT = new Point ((Scaling.EQUIPMENT_HELMET_X/ Scaling.EQUIPMENT_SLOT_WIDTH)
			,(Scaling.EQUIPMENT_HELMET_Y/ Scaling.EQUIPMENT_SLOT_WIDTH));
	public static final Point GLOVES_POINT = new Point ((Scaling.EQUIPMENT_GLOVES_X/ Scaling.EQUIPMENT_SLOT_WIDTH)
			,(Scaling.EQUIPMENT_GLOVES_Y/ Scaling.EQUIPMENT_SLOT_WIDTH));
	public static final Point BOOTS_POINT = new Point ((Scaling.EQUIPMENT_BOOTS_X/ Scaling.EQUIPMENT_SLOT_WIDTH)
			,(Scaling.EQUIPMENT_BOOTS_Y/ Scaling.EQUIPMENT_SLOT_WIDTH));
	public static final Point SHIELD_POINT = new Point ((Scaling.EQUIPMENT_SHIELD_X/ Scaling.EQUIPMENT_SLOT_WIDTH)
			,(Scaling.EQUIPMENT_SHIELD_Y/ Scaling.EQUIPMENT_SLOT_WIDTH));
	public static final Point LEGGINGS_POINT = new Point ((Scaling.EQUIPMENT_LEGGINGS_X/ Scaling.EQUIPMENT_SLOT_WIDTH)
			,(Scaling.EQUIPMENT_LEGGINGS_Y/ Scaling.EQUIPMENT_SLOT_WIDTH));
	
	private static final long serialVersionUID = 147952L;
	
	// DELETE THIS ONCE WE HAVE ALL THE SLOTS IN EQUIPMENT  boots, Shield,......
	private ArmorSlot uselessSlot = new ArmorSlot();
	
	private Equipment equipment;
	private BufferedImage weaponImage;
	private BufferedImage armorImage;
	private BufferedImage bootsImage;
	private BufferedImage shieldImage;
	private BufferedImage glovesImage;
	private BufferedImage leggingsImage;
	private BufferedImage helmetImage;
	
	
	// NOTE IT IS NOT SPECIFIC TO THE SLOT,  BUT ONLY TO EQUIPMENT
	//  			equipment.getArmorSlot().unequip();   will NOT work
	//   equipment.unequipArmor();  		WILL WORK
	public EquipmentView(Equipment equipment){
		this.equipment = equipment;
		equipment.addObserver(this);
		this.setEquipmentImages();
	}
	
	private BufferedImage getEquipmentSlotImage(String equipment, String itemImage){
		System.out.println(equipment + "    "+ itemImage+ "   "+SIZE_OF_SLOT + "    " +  EQUIPMENT_SLOT_OFFSET);
		System.out.println(Scaling.EQUIPMENT_SLOT_OFFSET_WIDTH+ "   "+ Scaling.EQUIPMENT_SLOT_OFFSET_HEIGHT);
		return ImageProcessing.overlayImages(equipment, SIZE_OF_SLOT,itemImage,EQUIPMENT_SLOT_OFFSET);
	}
	
	private BufferedImage setImage(BufferSlot slot, String imagePath){
		BufferedImage image;
		if (slot.has()){
			image= this.getEquipmentSlotImage(imagePath,slot.get().getImagePath());
		}
		else{
			image = ImageProcessing.scaleImage(SIZE_OF_SLOT, imagePath);
		}
		return image;
	}
	
	
	public void setEquipmentImages(){
		this.weaponImage = this.setImage(this.equipment.getSlot(Equipment.WEAPON_SLOT), EQUIPMENT_WEAPON_IMAGE_PATH);
		this.armorImage = this.setImage(this.equipment.getSlot(Equipment.ARMOR_SLOT), EQUIPMENT_ARMOR_IMAGE_PATH);
		this.bootsImage = this.setImage(this.uselessSlot, EQUIPMENT_BOOTS_IMAGE_PATH);
		this.glovesImage = this.setImage(this.uselessSlot, EQUIPMENT_GLOVES_IMAGE_PATH);
		this.shieldImage = this.setImage(this.uselessSlot, EQUIPMENT_SHIELD_IMAGE_PATH);
		this.leggingsImage = this.setImage(this.uselessSlot, EQUIPMENT_LEGGINGS_IMAGE_PATH);
		this.helmetImage = this.setImage(this.uselessSlot, EQUIPMENT_HELMET_IMAGE_PATH);
	}
	
	public void update() {
		this.setEquipmentImages();
	}
	
	public Equipment getEquipment(){
		return this.equipment;
	}

	public void paint(Graphics g){
		int OFFSET = Scaling.EQUIPMENT_OFFSET;
		g.setColor(Color.WHITE);
		System.out.println(POINT_OF_WEAPON+ "    " + Scaling.EQUIPMENT_OFFSET);
		g.drawImage(this.weaponImage, POINT_OF_WEAPON.getX() + OFFSET, POINT_OF_ARMOR.getY(), null);
		g.drawImage(this.armorImage, POINT_OF_ARMOR.getX() + OFFSET, POINT_OF_ARMOR.getY(),null);
		g.drawImage(this.bootsImage, POINT_OF_BOOTS.getX() + OFFSET, POINT_OF_BOOTS.getY(), null);
		g.drawImage(this.glovesImage, POINT_OF_GLOVES.getX() + OFFSET, POINT_OF_GLOVES.getY(), null);
		g.drawImage(this.shieldImage, POINT_OF_SHIELD.getX() + OFFSET, POINT_OF_SHIELD.getY(), null);
		g.drawImage(this.helmetImage, POINT_OF_HELMET.getX() + OFFSET, POINT_OF_HELMET.getY(), null);
		g.drawImage(this.leggingsImage, POINT_OF_LEGGINGS.getX() +OFFSET , POINT_OF_LEGGINGS.getY(), null);
	}
	
	public Dimension getPreferredSize(){
		return new Dimension(Scaling.EQUIPMENT_VIEW_WIDTH,Scaling.EQUIPMENT_VIEW_HEIGHT);
	}
}
