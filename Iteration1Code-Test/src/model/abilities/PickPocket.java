package model.abilities;

import model.entity.Entity;

public class PickPocket extends Spell{

	public PickPocket(Entity entity) {
		super(entity);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void doTheSpell(Entity entityToAffect) {
		if(this.entity.getOccupation().toString().equals("Hunter")){
			this.entity.setPickpocket();
			this.entity.makeGoldTransaction(100);
		}
	}

	@Override
	public int getManaRequirement() {
		return 0;
	}
}
