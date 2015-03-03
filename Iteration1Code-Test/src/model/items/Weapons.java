package model.items;

public enum Weapons {
	//All these will need to be UNIQUE weapons
	
	/*********TERMINATOR WEAPONS**********************/
	SWORD(new TerminatorSingleWeapon(1)),
	LONGSWORD(new TerminatorSingleWeapon(3)),
	DAVESWORD(new TerminatorSingleWeapon(100)),
	/*********HUNTER WEAPONS**********************/
	LONGBOW(new HunterWeapon(100)),
	/*********ALCHEMIST WEAPONS**********************/
//	AIR_STAFF(new AlchemistWeapon(10)),
//	WATER_STAFF(new AlchemistWeapon(10)),
	PHILOSOPHERS_STONE(new AlchemistWeapon(100));
	
	final public Weapon weapon;
	
	Weapons( Weapon item){
		this.weapon = item;
	}
	
	public boolean equals(Weapon item){
		if (this.weapon.getBonus() == item.getBonus()) return true;
		else return false;
	}
}