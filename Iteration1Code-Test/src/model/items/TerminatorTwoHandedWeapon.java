package model.items;

import model.Avatar;

public class TerminatorTwoHandedWeapon extends TerminatorWeapon{

	public TerminatorTwoHandedWeapon(int attack) {
		super(attack);
	}
	
	
	public boolean action(Avatar avatar){
		return avatar.equip(this);
	}
	
	
	public boolean isTHW(){return true;}


	public void accept(ItemVisitor visitor){
		visitor.accept(this);
	}
	
}
