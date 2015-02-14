package model;

import java.awt.image.BufferedImage;

import utilities.*;

public class Avatar extends Entity {
	private Inventory inventory = new Inventory();
	private BufferedImage image;
	private BufferedImage[] spriteSheet;
	private Equipment equipment = new Equipment();
	//private final String AVATAR_IMAGE = "src/res/img/sprite.jpg";
	private static String[] primaryStats = {"Agility", "Experience", "Hardiness",
											"HP", "Intellect", "Lives", "MP",
											"Movement", "Strength"};

	public Avatar() {
		//this.location = new Location(INITIAL_X_LIE,INITIAL_Y_LIE);	// this is a lie
		//occupation.initializeStats();
	}
	
	public Avatar(Occupation occupation) {
		super(occupation);
		String occString = occupation.getName().toUpperCase();
		SpriteSheetUtility util = new SpriteSheetUtility(occString);
		spriteSheet = (util.getSpriteArray());
		this.setEquipmentBegin();
		//this.location = new Location(INITIAL_X_LIE, INITIAL_Y_LIE);
	}
	
	public String getStat(String s){
		return Integer.toString(stats.get(s).getValue());
	}
	
	/*
	public void move(int x,int y){ //this is not needed either -Juan
		location.add(x,y);
		//System.out.println(location);
	}
	
	public void loadImage(Graphics g)
	{	
		image= ImageProcessing.scaleImage(Scaling.AVATAR_WIDTH, Scaling.AVATAR_HEIGHT,AVATAR_IMAGE);
		int x= location.getX();
		int y= location.getY();
		g.drawImage(image,Scaling.AVATAR_WIDTH*x,Scaling.AVATAR_HEIGHT*y,null);
	}
	*/
	
	
    private void setEquipmentBegin(){
    	int beginValue = 1;
    	this.equipment.equipArmor(new Armor(beginValue));
    	this.equipment.equipWeapon(new Weapon(beginValue));
    }
	
	public BufferedImage getImage(){
		BufferedImage imageToDisplay = spriteSheet[direction];
		image= ImageProcessing.scaleImage(Scaling.AVATAR_WIDTH, Scaling.AVATAR_HEIGHT, imageToDisplay);
		return image;
	}
	
	public Inventory getInventory(){
		return inventory;
	}
	
	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
	
	public Equipment getEquipment() {
		return this.equipment;
	}
	
	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}	
	
	// used for writing to the save file
	// name, occupation, stats, direction, inventory, equipment
	public String toString() {
		String result = "";
		result += "Avatar:" + this.name;
		result += "\n" + this.occupation;
		for (String key : primaryStats) result += "\n" + this.stats.get(key);
		result += "\nDirection:" + this.direction;
		result += "\n" + this.inventory;
		result += "\n" + this.equipment;
		return result;
	}
	
	/*
	//private void attack() {
	//	
	//}
	//may not need to override
	 */
	
	/*
	//private void useAbility() {
	//	
	//}
	//may not need to override
	 */
	
	
}