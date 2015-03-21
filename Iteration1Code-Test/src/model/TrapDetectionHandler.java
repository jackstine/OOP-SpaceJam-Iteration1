package model;

import java.util.Collection;
import java.util.Collections;

import model.entity.Avatar;

public class TrapDetectionHandler {
	private GameMap map;
	private Tile source;
	private int radius;
	private int direction;
	InfluenceSet set;
	Avatar avatar;
	private static int DEFAULT_RADIUS=3;
	
	public TrapDetectionHandler(GameMap map, Avatar avatar){
		this.map=map;
		this.radius=DEFAULT_RADIUS;
		this.avatar=avatar;
		this.direction=avatar.getDirection();
		this.source=map.getEntityTile(avatar);
		set= new RadialInfluenceSet(map,source,radius,direction);
	}
	
	public void detectTrap(){
		direction=avatar.getDirection();
		this.source=map.getEntityTile(avatar);
		map=World.getMap(avatar.getCurrMap());
		set= new RadialInfluenceSet(map,source,radius,direction);
		Collection<InfluenceTile> list= set.getInfluenceSet();
		if(map.getEntityTile(avatar).getTrap()!=null){
			map.getEntityTile(avatar).getTrap().apply(avatar);
		}
		
			for( InfluenceTile it : list){
				if(it.getTrap()!=null){
					if(it.getTrap().detectionRequired()<=avatar.getSkillValue("Trap")){
						it.getTrap().makeVisible();
					}
				}
			}
			
	}
}
