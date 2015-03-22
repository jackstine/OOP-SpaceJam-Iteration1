package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import model.entity.Avatar;
import model.visitor.OccupationVisitor;

public class TrapHandler {
	private GameMap map;
	private Tile source;
	private int radius;
	private int direction;
	InfluenceSet set;
	Avatar avatar;
	private static int DEFAULT_RADIUS=3;
	OccupationVisitor visitor;
	
	public TrapHandler(GameMap map, Avatar avatar){
		this.map=map;
		this.radius=DEFAULT_RADIUS;
		this.avatar=avatar;
		this.direction=avatar.getDirection();
		this.source=map.getEntityTile(avatar);
		set= new RadialInfluenceSet(map,source,radius,direction);
		visitor= new OccupationVisitor(avatar);
	}
	
	public void detectTrap(){
		
		avatar.getOccupation().accept(visitor);
		
		if(map.getEntityTile(avatar).getTrap()!=null){
			map.getEntityTile(avatar).getTrap().apply(avatar);
		}
		
		if(visitor.getBoolean()){
			for( InfluenceTile it : list){
				if(it.getTrap()!=null){
					if(it.getTrap().detectionRequired()<=avatar.getSkillValue("Trap")){
						it.getTrap().makeVisible();
					}
				}
			}
		
		}
	}
	public Collection<InfluenceTile> getSet(){
		direction=avatar.getDirection();
		this.source=map.getEntityTile(avatar);
		map=World.getMap(avatar.getCurrMap());
		set= new RadialInfluenceSet(map,source,radius,direction);
		Collection<InfluenceTile> list= set.getInfluenceSet();
		return list;
	}
	
	public Collection<Location> getTrap(){
		Collection<InfluenceTile> list= getSet();
		Collection<Location> locations= new ArrayList<Location>();
		for( InfluenceTile it : list){
			if(it.getTrap()!=null){
				locations.add()
			}
		}
	}
}
