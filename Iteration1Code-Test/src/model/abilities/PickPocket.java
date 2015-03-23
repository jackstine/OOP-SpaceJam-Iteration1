package model.abilities;

import java.util.Collection;

import model.GameLog;
import model.InfluenceTile;
import model.RadialInfluenceSet;
import model.World;
import model.entity.Entity;

public class PickPocket extends Spell{

	private RadialInfluenceSet pickPocketCheck;
	
	public PickPocket(Entity entity) {
		super(entity);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void doTheSpell(Entity entityToAffect) {
			pickPocketCheck = new RadialInfluenceSet(World.getMap(this.entity.getCurrMap()),World.getMap(this.entity.getCurrMap()).getEntityTile(this.entity),1,0);
			Collection<InfluenceTile> possibleEntityLocations = pickPocketCheck.getInfluenceSet();
			
			for(InfluenceTile tile : possibleEntityLocations){
				if(tile.getEntity() == entityToAffect){
					this.entity.setPickpocket();
					int goldGot = 100 + (entity.getSkillValue("Pick pocket") * 10);
					
					if(entityToAffect.getGold() > 0){
						this.entity.makeGoldTransaction(goldGot);
						entityToAffect.makeGoldTransaction(-goldGot);
						GameLog.writeToLog("Stealing", "You stole " + goldGot  + " gold");
					}
					else {
						GameLog.writeToLog("Stealing", "Stealing failed");
					}
				}
			}	
	}

	@Override
	public int getManaRequirement() {
		return 0;
	}
}
