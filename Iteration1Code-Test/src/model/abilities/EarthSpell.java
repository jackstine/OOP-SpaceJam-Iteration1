package model.abilities;

import java.util.Collection;

import model.GameMap;
import model.InfluenceTile;
import model.RadialInfluenceSet;
import model.World;
import model.entity.Entity;
import model.entity.EntityEffectHandler;

public class EarthSpell extends BaneAreaOfAffect{
	private int damage = 12;
	private int mana = 11;

	public EarthSpell(Entity entity) {
		super(entity);
	}
	public int getDamage() {
		return this.damage;
	}

	public int getManaRequirement() {
		return mana;
	}

	protected void doTheSpell(Entity entityToAffect) {
		GameMap map = World.getMap(entityToAffect.getCurrMap());
		RadialInfluenceSet radius = new RadialInfluenceSet(map,map.getTile(map.getLocation(entityToAffect)),1,0);
		Collection<InfluenceTile> tiles = radius.getInfluenceSet();
		for (InfluenceTile tile : tiles){
			if (tile.getTile().hasEntity()){
				Entity entity = tile.getTile().getEntity();
				damage = this.entity.getSkillValue("Bane") * damage;
				EntityEffectHandler.applyDamage(entity, damage);
			}
		}
	}
}
