package model.items;

public class TerminatorSingleWeapon extends TerminatorWeapon{

	public TerminatorSingleWeapon(int attack) {
		super(attack);
	}
	
	public void accept(ItemVisitor visitor){
		visitor.accept(this);
	}

}
