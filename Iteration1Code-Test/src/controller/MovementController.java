package controller;

import model.EffectHandler;
import model.GameMap;
import model.Location;
import model.NpcEffectHandler;
import model.Point;
import model.QuestHandler;
import model.World;
import model.Entity.Avatar;

public class MovementController {
	public static final Point NORTH = new Point(0,-1);
	public static final Point SOUTH = new Point(0,1);
	public static final Point SOUTHWEST = new Point(-1,1);
	public static final Point NORTHWEST = new Point(-1,-1);
	public static final Point WEST = new Point(-1,0);
	public static final Point NORTHEAST = new Point(1,-1);
	public static final Point SOUTHEAST = new Point(1,1);
	public static final Point EAST = new Point(1,0);
	
	
	private Avatar avatar;
	private World world;
	
	private EffectHandler effectHandler;
	private QuestHandler questHandler;
	private NpcEffectHandler npcEffectHandler;
	
	public MovementController(Avatar avatar,World world){
		this.avatar = avatar;
		this.world = world;
		this.effectHandler = new EffectHandler(avatar);
		this.questHandler = new QuestHandler(avatar);
		this.npcEffectHandler = new NpcEffectHandler(avatar);
	}
	
	public GameMap getCurrMap(){
		return world.getMap(avatar.getCurrMap());
	}
	
	public Location getAvatarLocation(){
		return getCurrMap().getLocation(avatar);
	}
	
	public void move(Point step, int direction){
		Location avatarLocation = this.getAvatarLocation();
		Location pointToMove = new Location(this.getAvatarLocation());
		pointToMove.addLocation(step);
		avatar.setDirection(direction);
		if(this.getCurrMap().isPassable(pointToMove)){
			getCurrMap().updateEntityLocation(avatar, pointToMove);
			questHandler.apply(this.getCurrMap().getTile(avatarLocation));
			effectHandler.apply(this.getCurrMap().getTile(avatarLocation));
		}
		else{
//			temp.add(point);
//			System.out.println(temp + "   this is the temp location");
//			System.out.println(avatarLocation + "   this is the avtar");
			//System.out.println(map.getTile(temp).getNPC());
			npcEffectHandler.apply(this.getCurrMap().getTileEntity(pointToMove),avatarLocation);
		}
		System.out.println(this.getCurrMap().getTile(avatarLocation).getTerrain());
		System.out.println(getCurrMap().getLocation(avatar).toString());
	}

}
