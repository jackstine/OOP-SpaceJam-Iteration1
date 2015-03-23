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
	public static final int BOARD_WIDTH = Scaling.NUM_TILES_WIDTH * Scaling.TILE_WIDTH;
	public static final int BOARD_HEIGHT = Scaling.NUM_TILES_HEIGHT * Scaling.TILE_HEIGHT;
	public static final int BOARD_X = 5;
	public static final int BOARD_Y = 0;
	public static final int CHAR_X = Scaling.STATUS_X;
	public static final int CHAR_Y = 0;
	public static final int CHAR_WIDTH = SCREEN_WIDTH - BOARD_WIDTH;
	public static final int CHAR_HEIGHT = 375;
	public static final int SYSTEM_BUTTON_X = Scaling.STATUS_X;
	public static final int SYSTEM_BUTTON_Y = CHAR_HEIGHT;
	public static final int SYSTEM_BUTTON_WIDTH = SCREEN_WIDTH - BOARD_WIDTH - 15;
	public static final int SYSTEM_BUTTON_HEIGHT = 50;
	public static final int STATUS_WIDTH = SCREEN_WIDTH - BOARD_WIDTH - 15;
	public static final int STATUS_HEIGHT = BOARD_HEIGHT - CHAR_HEIGHT - SYSTEM_BUTTON_HEIGHT;
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
	
	/**********************SPELLS***************************/
	public static final int SPELLS_WIDTH_NUM = 4;
	public static final int SPELLS_HEIGHT_NUM = 4;
	public static final int SPELL_OFFSET_X = 10;
	public static final int SPELL_OFFSET_Y = 5;
	public static final int SPELL_SPACE_X = 10 + Scaling.SPELL_WIDTH;
	public static final int SPELL_SPACE_Y = 10 + Scaling.SPELL_HEIGHT;
	//bane spells on the top
	public static final int FIRE_SPELL_X = SPELL_OFFSET_X;
	public static final int FIRE_SPELL_Y = SPELL_OFFSET_Y + SPELL_SPACE_Y;
	public static final int EARTH_SPELL_X = FIRE_SPELL_X + SPELL_SPACE_X;
	public static final int EARTH_SPELL_Y = FIRE_SPELL_Y;
	public static final int PLASMA_RAY_X = EARTH_SPELL_X + SPELL_SPACE_X;
	public static final int PLASMA_RAY_Y = FIRE_SPELL_Y;
	
	//enchantment spells in the middle
	public static final int PACIFISM_X = FIRE_SPELL_X;
	public static final int PACIFISM_Y = FIRE_SPELL_Y + SPELL_SPACE_Y;
	public static final int CONFUSE_X = PACIFISM_X + SPELL_SPACE_X;
	public static final int CONFUSE_Y = FIRE_SPELL_Y + SPELL_SPACE_Y;
	public static final int ANGRY_X = CONFUSE_X + SPELL_SPACE_X;
	public static final int ANGRY_Y =FIRE_SPELL_Y + SPELL_SPACE_Y;
	//boon spells in the below
	public static final int GLORY_HEAL_X = PLASMA_RAY_X + SPELL_SPACE_X;
	public static final int GLORY_HEAL_Y = PLASMA_RAY_Y;
	public static final int MANA_BUFF_X = ANGRY_X + SPELL_SPACE_X;
	public static final int MANA_BUFF_Y = ANGRY_Y;
	public static final int MAGIC_CIRCLE_X = Scaling.BIND_WOUNDS_X + SPELL_SPACE_X;
	public static final int MAGIC_CIRCLE_Y = Scaling.BIND_WOUNDS_Y;
	
	public static final Point FIRE_SPELL_POINT = getAbilityPoint(FIRE_SPELL_X,FIRE_SPELL_Y);
	public static final Point EARTH_SPELL_POINT = getAbilityPoint(EARTH_SPELL_X,EARTH_SPELL_Y);
	public static final Point PLASMA_RAY_POINT = getAbilityPoint(PLASMA_RAY_X,PLASMA_RAY_Y);
	public static final Point PACIFISM_POINT = getAbilityPoint(PACIFISM_X,PACIFISM_Y);
	public static final Point ANGRY_POINT = getAbilityPoint(ANGRY_X,ANGRY_Y);
	public static final Point GLORY_HEAL_POINT = getAbilityPoint(GLORY_HEAL_X,GLORY_HEAL_Y);
	public static final Point MANA_BUFF_POINT = getAbilityPoint(MANA_BUFF_X,MANA_BUFF_Y);
	public static final Point MAGIC_CIRCLE_POINT = getAbilityPoint(MAGIC_CIRCLE_X,MAGIC_CIRCLE_Y);
	public static final Point CONFUSE_POINT = getAbilityPoint(CONFUSE_X,CONFUSE_Y);
	
	
	public static final int SPELL_WIDTH = 30;
	public static final int SPELL_HEIGHT = 30;
	
	
	/**********************ABILITIES***************************/
	public static final int OBSERVATION_X = SPELL_OFFSET_X;
	public static final int OBSERVATION_Y = SPELL_OFFSET_Y;
	public static final int BIND_WOUNDS_X = OBSERVATION_X + SPELL_SPACE_X;
	public static final int BIND_WOUNDS_Y = OBSERVATION_Y;

	public static final int ABILITIES_WIDTH_NUM = 2;
	public static final int ABILITIES_HEIGHT_NUM = 1;
	
	public static final Point OBSERVATION_POINT = getAbilityPoint(OBSERVATION_X, OBSERVATION_Y);
	public static final Point BIND_WOUNDS_POINT = getAbilityPoint(BIND_WOUNDS_X, BIND_WOUNDS_Y);
	
	private static Point getAbilityPoint(int spellX, int spellY){
		return new Point( getSpellX(spellX), getSpellY(spellY) );
	}
	
	/*************************SNEEKY VIEW ABILITIES****************************/
	public static final int SNEAK_X = BIND_WOUNDS_X + SPELL_SPACE_X;
	public static final int SNEAK_Y = BIND_WOUNDS_Y;
	public static final int RANGE_ATTACK_X = SNEAK_X + SPELL_SPACE_X;
	public static final int RANGE_ATTACK_Y = SNEAK_Y;
	public static final int PICKPOCKET_X = OBSERVATION_X;
	public static final int PICKPOCKET_Y = SPELL_OFFSET_Y + SPELL_SPACE_Y;
	
	public static final Point SNEAK_POINT = getAbilityPoint(SNEAK_X, SNEAK_Y);
	public static final Point RANGE_ATTACK_POINT = getAbilityPoint(RANGE_ATTACK_X, RANGE_ATTACK_Y);
	public static final Point PICKPOCKET_POINT = getAbilityPoint(PICKPOCKET_X, PICKPOCKET_Y);
	
	
	private static int getSpellX(int spell){
		return spell/SPELL_SPACE_X;
	}
	private static int getSpellY(int spell){
		return (spell - SPELL_OFFSET_Y) / SPELL_SPACE_Y;
	}
	
	
	
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
	
	/**********************MERCHANTVIEW************************/
	public static final int MERCHANTVIEW_HEIGHT =  Inventory.ROW * 68;
	public static final int MERCHANTVIEW_WIDTH = Inventory.COL * 62;
	public static final int MERCHANTVIEW_X = 0;
	public static final int MERCHANTVIEW_Y = 0;
}
