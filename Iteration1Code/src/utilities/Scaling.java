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
	public static int SCREEN_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
	public static int SCREEN_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
	
	
	
	/**************CHARACTERCREATIONCONTROLLER***********/
	public static int CHARACTER_CREATION_WIDTH = 600;
	public static int CHARACTER_CREATION_HEIGHT = 600;
	
	
	/**************GAMECONTROLLER***********/
	public static int STATUS_X = Scaling.SCREEN_WIDTH/2 + 50;
	public static int STATUS_Y = 0;
	public static int STATUS_WIDTH = 700;
	public static int STATUS_HEIGHT = 700;
	public static int BOARD_WIDTH = 700;
	public static int BOARD_HEIGHT = 700;
	public static int BOARD_X = 5;
	public static int BOARD_Y = 0;
	public static int SYSTEM_BUTTON_X = 0;
	public static int SYSTEM_BUTTON_Y = 0;
	public static int SYSTEM_BUTTON_WIDTH = 100;
	public static int SYSTEM_BUTTON_HEIGHT = 25;
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
	public static int LOAD_TABLE_WIDTH = 600;
	public static int LOAD_TABLE_HEIGHT = 600;
	
	/**************MAINMENUCONTROLLER***********/
	public static int MAIN_MENU_WIDTH = 600;
	public static int MAIN_MENNU_HEIGHT = 600;
	
	/**************AVATAR***********/
	public static int AVATAR_WIDTH = Scaling.TILE_WIDTH;		//the avatar has to be the same size as a Tile
	public static int AVATAR_HEIGHT = Scaling.TILE_HEIGHT;
	
	
	/*************TILE***************/
	public static int TILE_WIDTH = 100;
	public static int TILE_HEIGHT = 100;
	public static Point TILE_SCALE = new Point(TILE_WIDTH,TILE_HEIGHT);
	public static int TILE_OVERLAY_IMAGE_OFFSET = 35;
	
	/*************ENTITYVIEW************/
	public static int ENTITY_MIDDLE = 300;
	
	/*************EQUIPMENTVIEW**************/
	public static int EQUIPMENT_WEAPON_X = 100;
	public static int EQUIPMENT_WEAPON_Y = 200;
	public static int EQUIPMENT_ARMOR_X = 200;
	public static int EQUIPMENT_ARMOR_Y = 0;
	public static int EQUIPMENT_SLOT_WIDTH = 100;
	public static int EQUIPMENT_SLOT_HEIGHT = 100;
	public static int EQUIPMENT_SLOT_OFFSET_WIDTH = 80;
	public static int EQUIPMENT_SLOT_OFFSET_HEIGHT = 80;
	public static int EQUIPMENT_VIEW_WIDTH = 200;
	public static int EQUIPMENT_VIEW_HEIGHT = 200;
	
	/*****************GAMEVIEW*********************/
	public static int GAME_VIEW_WIDTH = 700;
	public static int GAME_VIEW_HEIGHT = 700;
	
	/**********************INVENTORY************************/
	public static int INVENTORY_HEIGHT =  Inventory.ROW * Scaling.SLOT_VIEW_HEIGHT;
	public static int INVENTORY_WIDTH = Inventory.COL * Scaling.SLOT_VIEW_WIDTH;
	
	
	/*******************SLOTVIEW************************/
	public static int SLOT_VIEW_HEIGHT = 50;
	public static int SLOT_VIEW_WIDTH = 50;
	public static int SLOT_VIEW_SCALE = 50;			//should equal Slot_View_Scale
}
