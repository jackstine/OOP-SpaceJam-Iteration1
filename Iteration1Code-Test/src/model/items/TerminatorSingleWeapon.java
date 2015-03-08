package model.items;

import model.visitor.EquipableVisitor;
import model.visitor.ItemVisitor;

public class TerminatorSingleWeapon extends TerminatorWeapon{

	public TerminatorSingleWeapon(int attack) {
		super(attack);
	}
	
	public void accept(ItemVisitor visitor){
		visitor.accept(this);
	}

	public void accept(EquipableVisitor visitor){
		visitor.accept(this);
	}
}
