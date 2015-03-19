package model.spells;

import model.Entity.Entity;

public interface BoonSpell{

	public void applyBoon(Entity entityToAffect);
	
	public int getBoon();
}
