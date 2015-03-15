package controller;

import javax.swing.JFrame;

import model.EffectHandler;
import model.Entity.Entity;
import model.GameMap;

public class EntityMovementController {
	private GameMap map;
	private Entity entity;
	private GameController game;
	private EffectHandler effectHandler;
	
	public EntityMovementController(GameMap map, Entity entity, JFrame frame) {
		this.entity = entity;
		this.map = map;
		//TODO: Everything. Currently, moving and things like effect application are too coupled with 
		//Avatar to use with Entities such as NPC's. Major redesign will be needed to allow this.
		
	}
	
}
