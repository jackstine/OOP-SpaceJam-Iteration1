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
		map=World.getMap(avatar.getCurrMap());
		if(map.getEntityTile(avatar).getTrap()!=null){
			System.out.println("THIS RUNS");
			map.getEntityTile(avatar).getTrap().apply(avatar);
		}
		
		if(visitor.getBoolean()){
			Collection<Tile> t= getTrap();
			for(Tile it : t){
					if(avatar.getSkillValue("Trap") >= it.getTrap().detectionRequired()){
						makeVisible(it);
						removeTrap();
					}
				}
			}
		
		}
	public Collection<InfluenceTile> getSet(int r){
		direction=avatar.getDirection();
		this.source=map.getEntityTile(avatar);
		map=World.getMap(avatar.getCurrMap());
		set= new RadialInfluenceSet(map,source,r,direction);
		Collection<InfluenceTile> list= set.getInfluenceSet();
		return list;
	}
	
	public Collection<Tile> getTrap(){
		Collection<InfluenceTile> list= getSet(DEFAULT_RADIUS);
		Collection<Tile> locations= new ArrayList<Tile>();
		for( InfluenceTile it : list){
			if(it.getTrap()!=null){
				locations.add(it);
			}
		}
		return locations;
	}
	
	public void removeTrap(){
		Collection<InfluenceTile> list= getSet(1);
		for(InfluenceTile it : list){
			if(it.getTrap()!=null){
				Trap tr=it.getTrap();
				tr.destroy();
				tr=null;
			}
		}
	}
	
	public void makeVisible(Tile tile){
		tile.getTrap().makeVisible();
	}
}
