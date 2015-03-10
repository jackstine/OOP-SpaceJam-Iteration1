package model.items;

public enum Weapons {
	//All these will need to be UNIQUE weapons
	
	/*********TERMINATOR SINGLE WEAPONS**********************/
	SWORD(new TerminatorSingleWeapon(10),"src/res/img/sword.png"),
	LONGSWORD(new TerminatorSingleWeapon(50), "src/res/img/longsword.png"),
	DAVESWORD(new TerminatorSingleWeapon(100), "src/res/img/dave.jpg"),
	/********** TERMINATOR TWO HANDED WEAPONS ******************/
	RUNETHW(new TerminatorTwoHandedWeapon(50), "src/res/img/runeTHW.png"),
	DRAGONTHW(new TerminatorTwoHandedWeapon(100), "src/res/img/dragonTHW.png"),
	HALBERD(new TerminatorTwoHandedWeapon(150), "src/res/img/halberd.png"),
	/***************** TERMINATOR BRAWLING WEAPONS ******************/
	STEELCLAWS(new TerminatorBrawling(10),"src/res/img/steelClaws.png"),
	DRAGONCLAWS(new TerminatorBrawling(80), "src/res/img/dragonClaws.png"),
	WHITECLAWS(new TerminatorBrawling(130), "src/res/img/whiteClaws.png"),
	/*********HUNTER WEAPONS**********************/
	LONGBOW(new HunterWeapon(10), "src/res/img/longbow.png"),
	DRAGONBOW(new HunterWeapon(40), "src/res/img/dragonBow.png"),
	PRESTINEBOW(new HunterWeapon(60), "src/res/img/prestineBow.png"),
	/*********ALCHEMIST WEAPONS**********************/
	AIRSTAFF(new AlchemistWeapon(10),"src/res/img/airStaff.png"),
	LAVASTAFF(new AlchemistWeapon(50),"src/res/img/lavaStaff.png"),
	PHILOSOPHERS_STONE(new AlchemistWeapon(100),"src/res/img/philosopherStone.jpg");
	
	final public Weapon weapon;
	final public String image;
	
	Weapons( Weapon item, String image){
		this.weapon = item;
		this.image = image;
	}
	
	public boolean equals(Weapon item){
		if (this.weapon.getBonus() == item.getBonus()) return true;
		else return false;
	}
	public static String getTerminatorSingleWeaponImage(Weapon item){
		String image = null;
		if (SWORD.equals(item)) image = SWORD.image;
		else if (LONGSWORD.equals(item)) image = LONGSWORD.image;
		else if (DAVESWORD.equals(item)) image = DAVESWORD.image;
		return image;
	}
	public static String getTerminatorTHWImage(Weapon item){
		String image = null;
		if (RUNETHW.equals(item)) image = RUNETHW.image;
		else if (DRAGONTHW.equals(item)) image = DRAGONTHW.image;
		else if (HALBERD.equals(item)) image = HALBERD.image;
		return image;
	}
	public static String getTerminatorBrawling(Weapon item){
		String image = null;
		if (DRAGONCLAWS.equals(item)) image = DRAGONCLAWS.image;
		else if (WHITECLAWS.equals(item)) image = WHITECLAWS.image;
		else if (STEELCLAWS.equals(item)) image = STEELCLAWS.image;
		return image;
	}
	public static String getHuntersWeapon(Weapon item){
		String image = null;
		if (LONGBOW.equals(item)) image = LONGBOW.image;
		else if (DRAGONBOW.equals(item)) image = DRAGONBOW.image;
		else if (PRESTINEBOW.equals(item)) image = PRESTINEBOW.image;
		return image;
	}
	public static String getAlchemistWeapon(Weapon item){
		String image = null;
		if (PHILOSOPHERS_STONE.equals(item)) image = PHILOSOPHERS_STONE.image;
		else if (AIRSTAFF.equals(item)) image = AIRSTAFF.image;
		else if (LAVASTAFF.equals(item)) image = LAVASTAFF.image;
		return image;
	}
}