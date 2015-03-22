package controller;

import java.util.ArrayList;

import utilities.Directions;
import view.MapView;
import model.entity.*;
import model.GameMap;
import model.Location;
import model.Point;
import model.QuestHandler;
import model.Tile;
import model.World;

public abstract class NPCMovementController extends NPCController {

	public NPCMovementController(Entity entity){
		super(entity);
	}

	public void move(Point step, int direction) {	
		Location pointToMove = new Location(this.getEntityLocation());
		pointToMove.addLocation(step);
		entity.setDirection(direction);
		getCurrMap().updateEntityLocation(entity, pointToMove);
	}	
}
