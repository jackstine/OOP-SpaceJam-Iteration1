package model.abilities;

import model.GameLog;
import model.entity.Entity;

public class PickPocket extends Spell{

	public PickPocket(Entity entity) {
		super(entity);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void doTheSpell(Entity entityToAffect) {
			this.entity.setPickpocket();
			int goldGot = 100 + (entity.getSkillValue("Pickpocket") * 10);
			//GameLog.writeToLog("Entity Gold" , ""+ entityToAffect.getGold());
			if(entityToAffect.getGold() > 0){
			this.entity.makeGoldTransaction(100 + (entity.getSkillValue("Pickpocket") * 10));
			entityToAffect.makeGoldTransaction(-100);
			GameLog.writeToLog("Stealing", "You stole " + goldGot  + " gold");
			}
			else {
				GameLog.writeToLog("Stealing", "Stealing failed");
			}
	}

	@Override
	public int getManaRequirement() {
		return 0;
	}
}
