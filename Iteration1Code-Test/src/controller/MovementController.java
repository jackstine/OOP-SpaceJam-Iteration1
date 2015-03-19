package controller;

import view.MapView;
import model.GameMap;
import model.Location;
import model.NpcEffectHandler;
import model.Point;
import model.QuestHandler;
import model.World;
import model.entity.Avatar;

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
	private MapView mapView;
	
	private QuestHandler questHandler;
	
	public MovementController(Avatar avatar,World world, MapView mapView){
		this.mapView = mapView;
		this.avatar = avatar;
		this.world = world;
		this.questHandler = new QuestHandler(avatar);
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
			questHandler.apply(this.getCurrMap().getTile(pointToMove));
		}
		else{
			// FIX THIS LoD
			this.getCurrMap().getTileEntity(pointToMove).engage(avatar);
		}
		System.out.println(this.getCurrMap().getTile(avatarLocation).getTerrain());
		System.out.println(getCurrMap().getLocation(avatar).toString());
		this.mapView.repaint();
	}

}
