package model.items;

import model.visitor.EquipableVisitor;
import model.visitor.ItemVisitor;

public class TerminatorTwoHandedWeapon extends TerminatorWeapon{

	public TerminatorTwoHandedWeapon(int attack) {
		super(attack);
	}
	
	public boolean isTHW(){return true;}

	public void accept(ItemVisitor visitor){
		visitor.accept(this);
	}

	@Override
	public void accept(EquipableVisitor visitor) {
		visitor.accept(this);
	}
	
}