package controller;

import java.util.*;
import java.io.*;

import model.*;
import model.entity.*;
import model.items.*;
import model.occupation.*;
import model.slots.*;

public class SaveLoadController {
	
	public static void save(Game game) throws IOException {
		// create the PrintWriter that will write to the file
		PrintWriter out = new PrintWriter(new File("savedGame.txt"));
		
		// write everything about the avatar
		Avatar avatar = game.getAvatar();
		out.println(avatar);
		
		// write everything about the map
		World world = game.getWorld();
		out.println(world);		
		
		out.close();
		System.out.println("GAME SAVED\n---------------");
	}
	
	public static Game load() throws IOException {
		System.out.println("LOADING GAME");
		
		Scanner in = new Scanner(new File("savedGame.txt"));
		
		// load the Avatar information
		Avatar avatar = null;
		String[] avatarName = in.next().split(":");
		String name = avatarName[1];
		
		String[] avatarOccupation = in.next().split(":");
		String occupation = avatarOccupation[1];
		
		// fix this later
		if (occupation.equals("Terminator")) avatar = new Avatar(new Terminator());
		if (occupation.equals("Alchemist")) avatar = new Avatar(new Alchemist());
		if (occupation.equals("Hunter")) avatar = new Avatar(new Hunter());
		
		for (int i = 0; i < 9; i++) {
			String[] primaryStat = in.next().split(":");
			String key = primaryStat[0];
			int value = Integer.parseInt(primaryStat[1]);
			avatar.setStatValue(key, value);
		}		
		
		String[] avatarDirection = in.next().split(":");
		int direction = Integer.parseInt(avatarDirection[1]);

		avatar.setName(name);
		avatar.setDirection(direction);
		
		Inventory inventory = new Inventory("Empty Inventory");
		String[] avatarInventory = in.next().split(":");
		int inventorySize = Integer.parseInt(avatarInventory[1]);
		
		// query through all items in the inventory
		for (int j = 0; j < inventorySize; j++) {
			String[] inventoryItem = in.next().split(":");
			String itemType = inventoryItem[1];
			String weaponType = (itemType.equals("Armor") ? "" : inventoryItem[2]);
			String stringValue = inventoryItem[inventoryItem.length - 1];
			
			int itemValue = Integer.parseInt(stringValue);
			
			if (itemType.equals("Armor")) inventory.findAndEquip(new Armor(itemValue));
			else if (itemType.equals("Weapon")) inventory.findAndEquip(getWeapon(weaponType, itemValue));
		}
		
		avatar.getOccupation().createEmptyNecessities();
		
		// reading the equipment
		Equipment equipment = avatar.getOccupation().getEquipment();
		
		// reading the equipped chest
		String[] equipmentArmor = in.next().split(":");
		int armorValue = Integer.parseInt(equipmentArmor[2]);
		if (armorValue != -1) equipment.equip(new Armor(armorValue));
		
		// reading the equipped weapon
		String[] equipmentWeapon = in.next().split(":");
		String weaponType = equipmentWeapon[1];
		int weaponValue = Integer.parseInt(equipmentWeapon[2]);
		if (weaponValue != -1) equipWeapon(equipment, weaponType, weaponValue);
		
		// reading the equipped boots 
		String[] equipmentBoots = in.next().split(":");
		int bootsValue = Integer.parseInt(equipmentBoots[2]);
		if (bootsValue != -1) equipment.equip(new Boots(bootsValue));
		
		// reading the equipped gloves
		String[] equipmentGloves = in.next().split(":");
		int glovesValue = Integer.parseInt(equipmentGloves[2]);
		if (glovesValue != -1) equipment.equip(new Gloves(glovesValue));
		
		// reading the equipped helmet
		String[] equipmentHelmet = in.next().split(":");
		int helmetValue = Integer.parseInt(equipmentHelmet[2]);
		if (helmetValue != -1) equipment.equip(new Helmet(helmetValue));
		
		// reading the equipped leggins
		String[] equipmentLeggings = in.next().split(":");
		int leggingsValue = Integer.parseInt(equipmentLeggings[2]);
		if (leggingsValue != -1) equipment.equip(new Leggings(leggingsValue));
		
		// reading the equipped quiver
		String[] equipmentQuiver = in.next().split(":");
		int quiverValue = Integer.parseInt(equipmentQuiver[2]);
		if (quiverValue != -1) equipment.equip(new Projectile(quiverValue));
			
		// reading the equipped shield
		String[] equipmentShield = in.next().split(":");
		int shieldValue = Integer.parseInt(equipmentShield[2]);
		if (shieldValue != -1) equipment.equals(new Shield(shieldValue));
		
		// reading the equipped two-handed weapon
		String[] equipmentTHW = in.next().split(":");
		if (!equipmentTHW[0].equals("null")) {
			int THWValue = Integer.parseInt(equipmentTHW[2]);
			if (THWValue != -1) equipment.equip(new TerminatorTwoHandedWeapon(THWValue));
		}		
		
		String[] avatarLevels = in.next().split(":");
		int levels = Integer.parseInt(avatarLevels[1]);
		avatar.setLevels(levels);
		
		String[] currentMapString = in.next().split(":");
		String currentMap = currentMapString[1];
		
		avatar.setInventory(inventory);
		avatar.setEquipment(equipment);
		avatar.setCurrMap(currentMap);
		//game.setAvatar(avatar);
		
		String[] world = in.next().split(":");
		int numGames = Integer.parseInt(world[1]);
		
		Map<String, GameMap> games = new HashMap<String, GameMap>();
		
		for (int i = 0; i < numGames; i++) {
			// load the GameMap information
			String gameName = in.next();
			GameMap map = new GameMap();
			map.setAvatar(avatar);
			String[] mapSize = in.next().split(":");
			String[] size = mapSize[1].split(",");
			int height = Integer.parseInt(size[0]);
			int width = Integer.parseInt(size[1]);
			
			for (int row = 0; row < height; row++) {
				for (int col = 0; col < width; col++) {
					Terrain terrain = null;
					Decal decal = null;
					String[] tileLocation = in.next().split(":");
					
					String[] tileTerrain = in.next().split(":");
					String terrainType = tileTerrain[1];
					if (terrainType.equals("M")) terrain = new MountainTerrain();
					if (terrainType.equals("R")) terrain = new RadioactiveWasteTerrain();
					if (terrainType.equals("D")) terrain = new DesertTerrain();
					
					String[] tileDecal = in.next().split(":");
					if (tileDecal[0].equals("Decal")) {
						String decalID = tileDecal[1];
						if (decalID.equals("+")) decal = new RedCrossDecal();
						if (decalID.equals("X")){
							AreaEffect effect = null;
							String[] tileEffect = in.next().split(":");
							String effectType = tileEffect[0];
							if (effectType.equals("DeathAreaEffect")) effect = new DeathAreaEffect();
							if (effectType.equals("DamageAreaEffect")) {
								double value = Double.parseDouble(tileEffect[1]);
								effect = new DamageAreaEffect(value);
							}
							decal = new SkullAndCrossbonesDecal(effect);
						}
						if (decalID.equals("*")) decal = new GoldStarDecal();
						if (decalID.equals("O")) {
							String nextWorld = in.next();
							decal = new TeleportationDecal(nextWorld);
						}
					}
					Tile tile = new Tile(terrain, decal, row, col);
					
					Item item = null;
					String[] tileItem = in.next().split(":");
					if (tileItem[0].equals("Item")) {
						String itemType = tileItem[1];
						if (itemType.equals("GiantRock")) item = new GiantRock();
						else if (itemType.equals("TreasureChest")) {
							item = new TreasureChest();
							String actionDone = tileItem[2];
							if (actionDone.equals("true")) ((TreasureChest) item).setActionDone();
						} else {
							if (itemType.equals("Weapon")) {
								String weaponName = tileItem[2];
								int weaponBonus = Integer.parseInt(tileItem[3]);
								item = getWeapon(weaponName, weaponBonus);
							} else if (itemType.equals("Armor")) {
								String armorName = tileItem[2];
								int armorBonus = Integer.parseInt(tileItem[3]);
								item = getArmor(armorName, armorBonus);
							} else {
								double value = Double.parseDouble(tileItem[2]);
								if (itemType.equals("DamagingOneShotItem")) item = new DamagingOneShotItem(value);
								if (itemType.equals("HealingOneShotItem")) item = new HealingOneShotItem(value);
							}
						}
					}
					
					Entity npc = null;
					String[] tileEntity = in.next().split(":");
					
					if (!tileEntity[0].equals("null")) {
						if (tileEntity[0].equals("NPC")) {
							String typeNPC = tileEntity[1];
							if (typeNPC.equals("Orc")) npc = new Orc();
							if (typeNPC.equals("Skeleton")) npc = new Skeleton();
							if (typeNPC.equals("Merchant")) npc = new Merchant();
						}
						if (tileEntity[0].equals("Avatar")) npc = null;
						tile.setEntity(npc);
					}
					
					tile.setItem(item);	
					map.setTile(tile);
				}
			}
			
			
			// error here
			int entities = Integer.parseInt(in.next());
			for (int k = 0; k < entities; k++) {
				String[] entityLocation = in.next().split(":");
				String entityName = entityLocation[0];
				String[] location = entityLocation[1].split(",");
				int x = Integer.parseInt(location[0]);
				int y = Integer.parseInt(location[1]);
				// will fix this later to include all entities
				map.updateEntityLocation(avatar, new Location(x, y));
			}
			
			games.put(gameName, map);
		}
		
		Map<String, Integer> keySet = new HashMap<String, Integer>();
		
		for (int i = 0; i < 10; i++) {
			String line = in.next();
			String dir = line.substring(0, line.indexOf(":"));
			int key = Integer.parseInt(line.substring(line.indexOf(":") + 1));
			keySet.put(dir, key);
		}
		
		World finalWorld = new World(games, keySet);
		//game.setWorld(finalWorld);
		
		//game.setMap(map);
		System.out.println("GAME LOADED\n---------------");
		return new Game(finalWorld, avatar);
	}
	
	public static TakeableItem getWeapon(String name, int value) {
		if (name.equals("AlchemistWeapon")) return new AlchemistWeapon(value);
		else if (name.equals("HunterWeapon")) return new HunterWeapon(value);
		else if (name.equals("TerminatorBrawling")) return new TerminatorBrawling(value);
		else if (name.equals("TerminatorSingleWeapon")) return new TerminatorSingleWeapon(value);
		else return new TerminatorTwoHandedWeapon(value);
	}
	
	public static void equipWeapon(Equipment equipment, String name, int value) {
		if (name.equals("AlchemistWeapon")) equipment.equip(new AlchemistWeapon(value));
		else if (name.equals("HunterWeapon")) equipment.equip(new HunterWeapon(value));
		else if (name.equals("TerminatorBrawling")) equipment.equip(new TerminatorBrawling(value));
		else if (name.equals("TerminatorSingleWeapon")) equipment.equip(new TerminatorSingleWeapon(value));
		else equipment.equip(new TerminatorTwoHandedWeapon(value));
	}
	
	public static TakeableItem getArmor(String name, int value) {
		if (name.equals("Chest")) return new Armor(value);
		else if (name.equals("Boots")) return new Boots(value);
		else if (name.equals("Gloves")) return new Gloves(value);
		else if (name.equals("Helmet")) return new Helmet(value);
		else if (name.equals("Leggings")) return new Leggings(value);
		else if (name.equals("Quiver")) return new Projectile(value);
		else return new Shield(value);
	}
}
