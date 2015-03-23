package model.abilities;

import utilities.Scaling;
import model.Point;
import model.abilities.Spellable;
import model.entity.Entity;

public class Spells extends Abilities{
	public static final Point FIRE_SPELL_POINT = Scaling.FIRE_SPELL_POINT;
	public static final Point EARTH_SPELL_POINT = Scaling.EARTH_SPELL_POINT;
	public static final Point PLASMA_RAY_POINT = Scaling.PLASMA_RAY_POINT;
	public static final Point PACIFISM_POINT = Scaling.PACIFISM_POINT;
	public static final Point ANGRY_POINT = Scaling.ANGRY_POINT;
	public static final Point GLORY_HEAL_POINT = Scaling.GLORY_HEAL_POINT;
	public static final Point MANA_BUFF_POINT = Scaling.MANA_BUFF_POINT;
	public static final Point MAGIC_CIRCLE_POINT = Scaling.MAGIC_CIRCLE_POINT;
	public static final Point CONFUSE_POINT = Scaling.CONFUSE_POINT;
	
	public Spells(){}
	
	public Spells(Entity entity){
		super(entity);
	}
	
	protected void setSpells(){
		//TODO get rid of these magic numbers once we get this class on the go
		//abilities[this.FIRE_SPELL_POINT.getY()][this.FIRE_SPELL_POINT.getX()] = new FireSpell(entity);
		abilities[this.FIRE_SPELL_POINT.getY()][this.FIRE_SPELL_POINT.getX()] = new PolymorphSpell(entity);
		abilities[0][0] =new DanceSpell(this.entity);
		abilities[this.EARTH_SPELL_POINT.getY()][this.EARTH_SPELL_POINT.getX()] = new EarthSpell(this.entity);
		abilities[this.PLASMA_RAY_POINT.getY()][this.PLASMA_RAY_POINT.getX()] = new PlasmaRay(this.entity);
		abilities[this.GLORY_HEAL_POINT.getY()][this.GLORY_HEAL_POINT.getX()] = new GloryHeal(this.entity);
		abilities[this.MANA_BUFF_POINT.getY()][this.MANA_BUFF_POINT.getX()] = new ManaBuff(this.entity);
		abilities[this.PACIFISM_POINT.getY()][this.PACIFISM_POINT.getX()] = new PacifyAbility(this.entity);
		abilities[this.MAGIC_CIRCLE_POINT.getY()][this.MAGIC_CIRCLE_POINT.getX()] = null;
		abilities[this.ANGRY_POINT.getY()][this.ANGRY_POINT.getX()] = null;
		abilities[this.CONFUSE_POINT.getY()][this.CONFUSE_POINT.getX()] = null;
//		spells[2][1] = new BuffSpell(this.entity,-50,"Strength");
	}

}
