package controller;

import model.GameMap;
import model.Location;
import model.Point;
import model.QuestHandler;
import model.TrapHandler;
import model.World;
import model.entity.Avatar;
import view.MapView;

public class AvatarMovementController extends MovementController {

	private Avatar avatar;
	private QuestHandler questHandler;
	private TrapHandler trapHandler;
	
	public AvatarMovementController(Avatar avatar,World world, MapView mapView){
		this.mapView = mapView;
		this.avatar = avatar;
		this.world = world;
		this.questHandler = new QuestHandler(avatar,World.getMap(avatar.getCurrMap()));
		this.trapHandler= new TrapHandler(World.getMap(avatar.getCurrMap()),avatar);
	}

	public GameMap getCurrMap(){
		return world.getMap(avatar.getCurrMap());
	}
	
	public Location getAvatarLocation(){
		return getCurrMap().getLocation(avatar);
	}

	@Override
	public void move(Point step, int direction) {
		Location avatarLocation = this.getAvatarLocation();
		Location pointToMove = new Location(this.getAvatarLocation());
		pointToMove.addLocation(step);
		avatar.setDirection(direction);
		if(this.getCurrMap().isPassable(pointToMove)){
			getCurrMap().updateEntityLocation(avatar, pointToMove);
			questHandler.apply(this.getCurrMap().getTile(pointToMove));
			//trapHandler.detectTrap();
		}
		else{
			// FIX THIS LoD
			if (pointToMove != null)
				this.getCurrMap().getTileEntity(pointToMove).engage(avatar);
		}
		this.mapView.repaint();
	}
	
}
