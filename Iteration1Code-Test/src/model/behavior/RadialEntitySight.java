package model.behavior;

import java.util.Collection;

import model.DesertTerrain;
import model.GameMap;
import model.InfluenceTile;
import model.RadialInfluenceSet;
import model.Tile;
import model.entity.Avatar;
import model.entity.Entity;

public class RadialEntitySight extends IdleBehavior {

	private Avatar avatar;
	private RadialInfluenceSet sight;
	
	public RadialEntitySight (Avatar avatar) {
		this.avatar = avatar;
		sight = new RadialInfluenceSet(new GameMap(), new Tile(new DesertTerrain(), 0, 0), 0, 0);
	}
	
	public void setSight(RadialInfluenceSet sight) {
		this.sight = sight;
	}
	
	@Override
	public void perform(Entity receiver) {
		// TODO Auto-generated method stub
		
	}
	
	public Avatar getTarget() {
		return avatar;
	}

	public boolean contains(Entity entity) {
		Collection<InfluenceTile> list = sight.getInfluenceSet();
		for(InfluenceTile it : list) {
			if(it.hasEntity() && it.getEntity() == entity) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void getBuffs() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void kill() {
		// TODO Auto-generated method stub
		
	}
}
