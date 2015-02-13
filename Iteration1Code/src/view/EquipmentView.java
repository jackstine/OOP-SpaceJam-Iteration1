package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import utilities.ImageProcessing;
import model.Equipment;
import model.Point;

public class EquipmentView extends JPanel{
	private final Point POINT_OF_WEAPON = new Point(100,200);
	private final Point POINT_OF_ARMOR = new Point(200,0);
	private final Point SIZE_OF_SLOT = new Point(100,100);
	private final Point EQUIPMENT_SLOT_OFFSET = new Point(80,80);
	
	private final String EQUIPMENT_WEAPON_IMAGE_PATH = "src/res/img/Equipment_Weapon_Slot.png";
	private final String EQUIPMENT_ARMOR_IMAGE_PATH = "src/res/img/Equipment_Armor_Slot.png";
	
	private static final long serialVersionUID = 147952L;
	
	private Equipment equipment;
	private BufferedImage equipmentWeaponImage;
	private BufferedImage equipmentArmorImage;
	
	
	// NOTE IT IS NOT SPECIFIC TO THE SLOT,  BUT ONLY TO EQUIPMENT
	//  			equipment.getArmorSlot().unequip();   will NOT work
	//   equipment.unequipArmor();  		WILL WORK
	public EquipmentView(Equipment equipment){
		this.equipment = equipment;
		equipment.addObserver(this);
		this.setEquipmentImages();
	}
	
	private BufferedImage getEquipmentSlotImage(String equipment, String itemImage){
		return ImageProcessing.overlayImages(equipment, SIZE_OF_SLOT,itemImage,EQUIPMENT_SLOT_OFFSET);
	}
	
	public void setEquipmentImages(){
		if (this.equipment.getWeaponSlot().has()){
			this.equipmentWeaponImage = this.getEquipmentSlotImage(EQUIPMENT_WEAPON_IMAGE_PATH,this.equipment.getWeaponSlot().get().getImagePath());
		}
		else{
			this.equipmentWeaponImage = ImageProcessing.scaleImage(SIZE_OF_SLOT, EQUIPMENT_WEAPON_IMAGE_PATH);
		}
		if (this.equipment.getArmorSlot().has()){
			this.equipmentArmorImage = this.getEquipmentSlotImage(EQUIPMENT_ARMOR_IMAGE_PATH,this.equipment.getArmorSlot().get().getImagePath());
		}
		else{
			this.equipmentArmorImage = ImageProcessing.scaleImage(SIZE_OF_SLOT, EQUIPMENT_ARMOR_IMAGE_PATH);
		}
	}
	
	public void update() {
		this.setEquipmentImages();
	}

	public void paint(Graphics g){
		g.drawImage(this.equipmentWeaponImage, POINT_OF_WEAPON.getX(), POINT_OF_WEAPON.getY(), null);
		g.drawImage(this.equipmentArmorImage, POINT_OF_ARMOR.getX(), POINT_OF_ARMOR.getY(),null);
	}
	
	public Dimension getPreferredSize(){
		return new Dimension(200,200);
	}
}
