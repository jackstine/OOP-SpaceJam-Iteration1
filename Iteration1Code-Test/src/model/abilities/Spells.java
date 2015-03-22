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
	
	private Entity entity;
	private Point selectedSpell;
	
	private final Spellable[][] spells= new Spellable[Scaling.SPELLS_WIDTH_NUM][Scaling.SPELLS_HEIGHT_NUM];
	
	public Spells(Entity entity){
		this.entity = entity;
	}
	
	public Spells(){
	}
	
	private void setSpells(){
		//TODO get rid of these magic numbers once we get this class on the go
		spells[this.FIRE_SPELL_POINT.getX()][this.FIRE_SPELL_POINT.getY()] = new FireSpell(this.entity);
//		spells[0][0] =new BuffSpell(this.entity,100,"Movement");
		spells[this.EARTH_SPELL_POINT.getX()][this.EARTH_SPELL_POINT.getY()] = new EarthSpell(this.entity);
		spells[this.PLASMA_RAY_POINT.getX()][this.PLASMA_RAY_POINT.getY()] = new PlasmaRay(this.entity);
		spells[this.GLORY_HEAL_POINT.getX()][this.GLORY_HEAL_POINT.getY()] = new GloryHeal(this.entity);
		spells[this.MANA_BUFF_POINT.getX()][this.MANA_BUFF_POINT.getY()] = new ManaBuff(this.entity);
		spells[this.PACIFISM_POINT.getX()][this.PACIFISM_POINT.getY()] = null;
		spells[this.MAGIC_CIRCLE_POINT.getX()][this.MAGIC_CIRCLE_POINT.getY()] = null;
		spells[this.ANGRY_POINT.getX()][this.ANGRY_POINT.getY()] = null;
		spells[this.CONFUSE_POINT.getX()][this.CONFUSE_POINT.getY()] = null;
//		spells[2][1] = new BuffSpell(this.entity,-50,"Strength");
	}
	
	public void setSelectedSpell(Point spell){
		this.selectedSpell = spell;
	}
	public Spellable getSelectedSpell(){
		if (this.selectedSpell != null)
			return this.spells[this.selectedSpell.getY()][this.selectedSpell.getX()];
		else return null;
	}

	public void setEntity(Entity entity) {
		this.entity = entity;
		this.setSpells();
	}

}
