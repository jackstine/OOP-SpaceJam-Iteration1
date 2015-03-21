package model.items;

import model.visitor.EquipableVisitor;
import model.visitor.ItemVisitor;
import model.visitor.WeaponVisitor;

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
	
	public String toString() {
		return "Weapon:TerminatorTwoHandedWeapon:" + this.getBonus();
	}

	public void accept(WeaponVisitor visitor) {
		visitor.accept(this);
	}
	
}
