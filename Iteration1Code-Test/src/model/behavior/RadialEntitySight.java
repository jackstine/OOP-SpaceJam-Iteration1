package model.behavior;

import java.util.Collection;

import model.DesertTerrain;
import model.GameMap;
import model.InfluenceTile;
import model.RadialInfluenceSet;
import model.Tile;
import model.World;
import model.entity.Avatar;
import model.entity.Entity;

public class RadialEntitySight {

	private Avatar avatar;
	private RadialInfluenceSet sight;
	
	public RadialEntitySight (Avatar avatar) {
		this.avatar = avatar;
		sight = new RadialInfluenceSet(World.getMap(avatar.getCurrMap()), new Tile(new DesertTerrain(), 0, 0), 0, 0);
	}
	
	public void setSight(RadialInfluenceSet sight) {
		this.sight = sight;
	}
	
	public Avatar getTarget() {
		return avatar;
	}

	public synchronized boolean contains(Entity entity) {
		Collection<InfluenceTile> list = sight.getInfluenceSet();
		for(InfluenceTile it : list) {
			if(it.hasEntity() && it.getEntity() == entity) {
				return true;
			}
		}
		return false;
	}
}
