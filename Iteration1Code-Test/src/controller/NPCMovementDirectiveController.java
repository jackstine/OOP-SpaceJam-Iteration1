package controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

import utilities.Directions;
import model.GameMap;
import model.Location;
import model.Point;
import model.Tile;
import model.entity.*;

public abstract class NPCMovementDirectiveController extends NPCMovementController{
	private Entity target;
	
	public NPCMovementDirectiveController(Entity entity){
		super(entity);
	}
}
