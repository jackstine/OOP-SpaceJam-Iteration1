package model.spells;

import model.entity.Entity;

public interface BoonSpell{

	public void applyBoon(Entity entityToAffect);
	
	public int getBoon();
}
