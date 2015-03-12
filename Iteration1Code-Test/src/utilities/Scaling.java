package utilities;

import java.awt.Toolkit;

import model.Point;
import model.slots.Inventory;

// ALL scaling conventions are in here
public final class Scaling {
	
	/*   SCALING   BUSINESS   Super Saiyan SHIT
	 * 		OK so Tile affects alot of these thingies
	 * 
	 * */
	
	//TODO factor all these things to 1 size that fits the map all the time
	//At the time that this was done the magic numbers were the respective ratios
	/*************************************************************/
	public static final int SCREEN_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
	public static final int SCREEN_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
	public static final int SCREEN_WIDTH_CENTER = SCREEN_WIDTH / 2;
	public static final int SCREEN_HEIGHT_CENTER = SCREEN_HEIGHT / 2;
	
	
	
	/**************CHARACTERCREATIONCONTROLLER***********/
	public static final int CHARACTER_CREATION_WIDTH = 1200;
	public static final int CHARACTER_CREATION_HEIGHT = 600;
	
	
	/**************GAMECONTROLLER***********/
	public static final int CHAR_X = Scaling.STATUS_X;
	public static final int CHAR_Y = 0;
	public static final int CHAR_WIDTH = 870;
	public static final int CHAR_HEIGHT = 400;
	public static final int BOARD_WIDTH = Scaling.NUM_TILES_WIDTH * Scaling.TILE_WIDTH;
	public static final int BOARD_HEIGHT = Scaling.NUM_TILES_HEIGHT * Scaling.TILE_HEIGHT;
	public static final int BOARD_X = 5;
	public static final int BOARD_Y = 0;
	public static final int SYSTEM_BUTTON_X = Scaling.STATUS_X;
	public static final int SYSTEM_BUTTON_Y = CHAR_HEIGHT;
	public static final int SYSTEM_BUTTON_WIDTH = CHAR_WIDTH;
	public static final int SYSTEM_BUTTON_HEIGHT = 50;
	public static final int STATUS_WIDTH = CHAR_WIDTH;
	public static final int STATUS_HEIGHT = 230;
	public static final int STATUS_X = BOARD_WIDTH + 18;
	public static final int STATUS_Y = SYSTEM_BUTTON_Y + SYSTEM_BUTTON_HEIGHT;
	public static final int GAME_CONTROLLER_INPUT_X = 101;
	public static final int GAME_CONTROLLER_INPUT_Y = 0;
	public static final int GAME_CONTROLLER_INPUT_HEIGHT = 25;
	public static final int GAME_CONTROLLER_INPUT_WIDTH = 200;
	public static final int GAME_CONTROLLER_SAVED_TEXT_X = 100;
	public static final int GAME_CONTROLLER_SAVED_TEXT_Y = 100;
	public static final int GAME_CONTROLLER_SAVED_TEXT_WIDTH = 200;
	public static final int GAME_CONTROLLER_SAVED_TEXT_HEIGHT = 25;
	public static final int GAME_CONTROLLER_BOARD_X = 500;
	public static final int GAME_CONTROLLER_BOARD_Y = 0;
	public static final int GAME_CONTROLLER_BOARD_WIDTH = BOARD_WIDTH;		//ASSUMING THAT THIS IS CORRECT
	public static final int GAME_CONTROLLER_BOARD_HEIGHT = BOARD_HEIGHT;
	
	/**************JINTERNALFRAMES***********/
	public static final int INTERNAL_X = 400;
	public static final int INTERNAL_Y = 50;
	public static final int INTERNAL_WIDTH = 500;
	public static final int INTERNAL_HEIGHT = 300;
	
	
	/**************LOADGAMECONTROLLER***********/
	public static final int LOAD_TABLE_WIDTH = 600;
	public static final int LOAD_TABLE_HEIGHT = 600;
	
	/**************MAINMENUCONTROLLER***********/
	public static final int MAIN_MENU_WIDTH = 1200;
	public static final int MAIN_MENU_HEIGHT = 600;
	
	/**************AVATAR***********/
	public static final int AVATAR_WIDTH = Scaling.TILE_WIDTH;		//the avatar has to be the same size as a Tile
	public static final int AVATAR_HEIGHT = Scaling.TILE_HEIGHT;
	
	
	/*************TILE***************/
	//   NUM TILES WIDTH and NUM_TILES_HEIGHT   display the number of tiles on the map board
	public static final int TILE_WIDTH = 100;
	public static final int TILE_HEIGHT = 100;
	public static final Point TILE_SCALE = new Point(TILE_WIDTH,TILE_HEIGHT);
	public static final int TILE_OVERLAY_IMAGE_OFFSET = (int) (35 * (TILE_WIDTH/100.0));
	public static final Point TILE_TAKEABLE_ITEM_OFFSET = new Point(TILE_WIDTH - TILE_OVERLAY_IMAGE_OFFSET, TILE_HEIGHT - TILE_OVERLAY_IMAGE_OFFSET);
	
	/*************ENTITYVIEW************/
	public static final int ENTITY_MIDDLE = TILE_WIDTH*3;		//starts 3 spaces on the map
	
	/*************EQUIPMENTVIEW**************/
	public static final int EQUIPMENT_WEAPON_X = 0;
	public static final int EQUIPMENT_WEAPON_Y = 100;
	//  Armor is directly below the Helmet
	public static final int EQUIPMENT_ARMOR_X = Scaling.EQUIPMENT_HELMET_X;
	public static final int EQUIPMENT_ARMOR_Y = Scaling.EQUIPMENT_HELMET_Y + Scaling.EQUIPMENT_SLOT_HEIGHT;
	// Helmet is the top view of the Equipment View
	public static final int EQUIPMENT_HELMET_X = Scaling.EQUIPMENT_SLOT_WIDTH;
	public static final int EQUIPMENT_HELMET_Y = 0;
	//Quiver is right of the Helmet///  for now
	public static final int EQUIPMENT_QUIVER_X = Scaling.EQUIPMENT_HELMET_X + Scaling.EQUIPMENT_SLOT_WIDTH;
	public static final int EQUIPMENT_QUIVER_Y = Scaling.EQUIPMENT_HELMET_Y;
	// left of the Armor
	public static final int EQUIPMENT_SHIELD_X = EQUIPMENT_ARMOR_X + Scaling.EQUIPMENT_SLOT_WIDTH;
	public static final int EQUIPMENT_SHIELD_Y = EQUIPMENT_ARMOR_Y;
	// below the Armor
	public static final int EQUIPMENT_LEGGINGS_X = EQUIPMENT_ARMOR_X;
	public static final int EQUIPMENT_LEGGINGS_Y = EQUIPMENT_ARMOR_Y + Scaling.EQUIPMENT_SLOT_HEIGHT;
	// below the Leggings
	public static final int EQUIPMENT_BOOTS_X = EQUIPMENT_LEGGINGS_X;
	public static final int EQUIPMENT_BOOTS_Y = EQUIPMENT_LEGGINGS_Y + Scaling.EQUIPMENT_SLOT_HEIGHT;
	//Left of LEGGINGS
	public static final int EQUIPMENT_GLOVES_X = Scaling.EQUIPMENT_LEGGINGS_X - Scaling.EQUIPMENT_SLOT_HEIGHT;
	public static final int EQUIPMENT_GLOVES_Y = EQUIPMENT_LEGGINGS_Y;
	//SLOT information
	public static final int EQUIPMENT_SLOT_WIDTH = 75;
	public static final int EQUIPMENT_SLOT_HEIGHT = 75;
	public static final int EQUIPMENT_SLOT_OFFSET_WIDTH = (int) (80 * (Scaling.EQUIPMENT_SLOT_WIDTH/100.0));
	public static final int EQUIPMENT_SLOT_OFFSET_HEIGHT = (int) (80 * (Scaling.EQUIPMENT_SLOT_HEIGHT/100.0));
	public static final int EQUIPMENT_SLOTS_WIDTH_NUM = 4;
	public static final int EQUIPMENT_SLOTS_HEIGHT_NUM = 5;
	public static final int EQUIPMENT_VIEW_WIDTH = Scaling.EQUIPMENT_SLOT_WIDTH * EQUIPMENT_SLOTS_WIDTH_NUM;
	public static final int EQUIPMENT_VIEW_HEIGHT = Scaling.EQUIPMENT_SLOT_HEIGHT * EQUIPMENT_SLOTS_HEIGHT_NUM;
	
	
	
	/*****************GAMEVIEW*********************/
	//   NUM TILES WIDTH and NUM_TILES_HEIGHT   display the number of tiles on the map board
	public static final int NUM_TILES_WIDTH = 7;
	public static final int NUM_TILES_HEIGHT = 7;
	public static final int GAME_VIEW_WIDTH = NUM_TILES_WIDTH * TILE_WIDTH;
	public static final int GAME_VIEW_HEIGHT = NUM_TILES_HEIGHT * TILE_HEIGHT;
	
	/**********************INVENTORY************************/
	public static final int INVENTORY_HEIGHT =  Inventory.ROW * Scaling.SLOT_VIEW_HEIGHT;
	public static final int INVENTORY_WIDTH = Inventory.COL * Scaling.SLOT_VIEW_WIDTH;
	
	
	/*******************SLOTVIEW************************/
	public static final int SLOT_VIEW_HEIGHT = 60;
	public static final int SLOT_VIEW_WIDTH = 60;
	public static final int SLOT_VIEW_SCALE = 60;			//should equal Slot_View_Scale
}
