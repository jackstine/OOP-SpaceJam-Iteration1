package model.abilities;

import model.Point;
import model.entity.Entity;
import utilities.Scaling;

public class Sneeky extends Abilities{
	public static final Point RANGE_ATTACK_POINT = Scaling.RANGE_ATTACK_POINT;
	public static final Point SNEAK_POINT = Scaling.SNEAK_POINT;
	public static final Point PICKPOCKET_POINT = Scaling.PICKPOCKET_POINT;
	
	public Sneeky(){}
	
	public Sneeky(Entity entity){
		super(entity);
	}
	
	protected void setSpells(){
		//TODO get rid of these magic numbers once we get this class on the go
		abilities[this.RANGE_ATTACK_POINT.getY()][this.RANGE_ATTACK_POINT.getX()] = new RangeAttack(entity);
		abilities[this.SNEAK_POINT.getY()][this.SNEAK_POINT.getX()] = new Sneak(this.entity);
		abilities[this.PICKPOCKET_POINT.getY()][this.PICKPOCKET_POINT.getX()] = new PickPocket(this.entity);
	}

}
