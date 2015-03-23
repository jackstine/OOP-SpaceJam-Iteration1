package model.abilities;

import java.util.Collection;

import model.GameMap;
import model.InfluenceTile;
import model.RadialInfluenceSet;
import model.World;
import model.entity.Entity;

public abstract class SpellAreaOfEffect extends Spell{

	public SpellAreaOfEffect(Entity entity) {
		super(entity);
	}
	
	public final void doTheSpell(Entity entityToAffect){
		GameMap map = World.getMap(entityToAffect.getCurrMap());
		RadialInfluenceSet radius = new RadialInfluenceSet(map,map.getTile(map.getLocation(entityToAffect)),this.getRadius(),0);
		Collection<InfluenceTile> tiles = radius.getInfluenceSet();
		for (InfluenceTile tile : tiles){
			if (tile.getTile().hasEntity()){
				Entity entity = tile.getTile().getEntity();
				this.happensInAreaAffect(entity);
			}
		}
	}
	
	public abstract void happensInAreaAffect(Entity entityToAffect);
	public abstract int getRadius();

}
