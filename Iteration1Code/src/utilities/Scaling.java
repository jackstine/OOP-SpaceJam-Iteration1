package utilities;

import java.awt.Toolkit;

import view.SlotView;
import model.Inventory;
import model.Point;

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
	
	
	
	/**************CHARACTERCREATIONCONTROLLER***********/
	public static final int CHARACTER_CREATION_WIDTH = 600;
	public static final int CHARACTER_CREATION_HEIGHT = 600;
	
	
	/**************GAMECONTROLLER***********/
	public static int CHAR_X = Toolkit.getDefaultToolkit().getScreenSize().width/2 + 35;
	public static int CHAR_Y = 0;
	public static int CHAR_WIDTH = 625;
	public static int CHAR_HEIGHT = 500;
	public static int BOARD_WIDTH = 700;
	public static int BOARD_HEIGHT = 700;
	public static int BOARD_X = 5;
	public static int BOARD_Y = 0;
	public static int SYSTEM_BUTTON_X = Toolkit.getDefaultToolkit().getScreenSize().width/2 + 35;
	public static int SYSTEM_BUTTON_Y = CHAR_HEIGHT;
	public static int SYSTEM_BUTTON_WIDTH = CHAR_WIDTH;
	public static int SYSTEM_BUTTON_HEIGHT = 50;
	public static int STATUS_WIDTH = CHAR_WIDTH;
	public static int STATUS_HEIGHT = 230;
	public static int STATUS_X = BOARD_WIDTH;
	public static int STATUS_Y = SYSTEM_BUTTON_Y + SYSTEM_BUTTON_HEIGHT;
	public static int GAME_CONTROLLER_INPUT_X = 101;
	public static int GAME_CONTROLLER_INPUT_Y = 0;
	public static int GAME_CONTROLLER_INPUT_HEIGHT = 25;
	public static int GAME_CONTROLLER_INPUT_WIDTH = 200;
	public static int GAME_CONTROLLER_SAVED_TEXT_X = 100;
	public static int GAME_CONTROLLER_SAVED_TEXT_Y = 100;
	public static int GAME_CONTROLLER_SAVED_TEXT_WIDTH = 200;
	public static int GAME_CONTROLLER_SAVED_TEXT_HEIGHT = 25;
	public static int GAME_CONTROLLER_BOARD_X = 500;
	public static int GAME_CONTROLLER_BOARD_Y = 0;
	public static int GAME_CONTROLLER_BOARD_WIDTH = 700;
	public static int GAME_CONTROLLER_BOARD_HEIGHT = 700;
	
	/**************LOADGAMECONTROLLER***********/
	public static final int LOAD_TABLE_WIDTH = 600;
	public static final int LOAD_TABLE_HEIGHT = 600;
	
	/**************MAINMENUCONTROLLER***********/
	public static final int MAIN_MENU_WIDTH = 600;
	public static final int MAIN_MENNU_HEIGHT = 600;
	
	/**************AVATAR***********/
	public static final int AVATAR_WIDTH = Scaling.TILE_WIDTH;		//the avatar has to be the same size as a Tile
	public static final int AVATAR_HEIGHT = Scaling.TILE_HEIGHT;
	
	
	/*************TILE***************/
	public static final int TILE_WIDTH = 100;
	public static final int TILE_HEIGHT = 100;
	public static final Point TILE_SCALE = new Point(TILE_WIDTH,TILE_HEIGHT);
	public static final int TILE_OVERLAY_IMAGE_OFFSET = 35 * (TILE_WIDTH/100);
	
	/*************ENTITYVIEW************/
	public static final int ENTITY_MIDDLE = TILE_WIDTH*3;		//starts 3 spaces on the map
	
	/*************EQUIPMENTVIEW**************/
	public static final int EQUIPMENT_WEAPON_X = 100;
	public static final int EQUIPMENT_WEAPON_Y = 200;
	public static final int EQUIPMENT_ARMOR_X = 200;
	public static final int EQUIPMENT_ARMOR_Y = 0;
	public static final int EQUIPMENT_SLOT_WIDTH = 100;
	public static final int EQUIPMENT_SLOT_HEIGHT = 100;
	public static final int EQUIPMENT_SLOT_OFFSET_WIDTH = 80;
	public static final int EQUIPMENT_SLOT_OFFSET_HEIGHT = 80;
	public static final int EQUIPMENT_VIEW_WIDTH = 200;
	public static final int EQUIPMENT_VIEW_HEIGHT = 200;
	
	/*****************GAMEVIEW*********************/
	public static final int NUM_TILES_WIDTH = 7;
	public static final int NUM_TILES_HEIGHT = 7;
	public static final int GAME_VIEW_WIDTH = NUM_TILES_WIDTH * TILE_WIDTH;
	public static final int GAME_VIEW_HEIGHT = NUM_TILES_HEIGHT * TILE_HEIGHT;
	
	/**********************INVENTORY************************/
	public static final int INVENTORY_HEIGHT =  Inventory.ROW * Scaling.SLOT_VIEW_HEIGHT;
	public static final int INVENTORY_WIDTH = Inventory.COL * Scaling.SLOT_VIEW_WIDTH;
	
	
	/*******************SLOTVIEW************************/
	public static final int SLOT_VIEW_HEIGHT = 50;
	public static final int SLOT_VIEW_WIDTH = 50;
	public static final int SLOT_VIEW_SCALE = 50;			//should equal Slot_View_Scale
}
