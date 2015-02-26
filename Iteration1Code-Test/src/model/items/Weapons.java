package model.items;

public enum Weapons {
	//All these will need to be UNIQUE weapons
	
	
	SWORD (new Weapon(2)),
	LONGSWORD(new Weapon(3));
	
	final Weapon item;
	
	Weapons( Weapon item){
		this.item = item;
	}

}