package model.abilities;

import model.Point;
import model.entity.Entity;
import utilities.Scaling;

public class Abilities {
	private static final Point OBSERVATION_POINT = Scaling.OBSERVATION_POINT;
	public static final Point BIND_WOUNDS_POINT = Scaling.BIND_WOUNDS_POINT;
	
	protected Entity entity;
	private Point selectedAbility;
	private Spellable[][] abilities= new Spellable[Scaling.SPELLS_WIDTH_NUM][Scaling.SPELLS_HEIGHT_NUM];

	public Abilities(){}
	
	public Abilities(Entity entity){
		this.entity = entity;
	}
	
	private void setAbilities(){
		abilities[this.OBSERVATION_POINT.getX()][this.OBSERVATION_POINT.getY()] = new Observation(this.entity);
		abilities[this.BIND_WOUNDS_POINT.getX()][this.BIND_WOUNDS_POINT.getY()] = new BindWound(this.entity);
		this.setSpells();
	}
	
	protected void setSpells(){}
	
	public void setSelectedSpell(Point spell){
		this.selectedAbility = spell;
	}
	public Spellable getSelectedSpell(){
		if (this.selectedAbility != null)
			return this.abilities[this.selectedAbility.getY()][this.selectedAbility.getX()];
		else return null;
	}

	public void setEntity(Entity entity) {
		this.entity = entity;
		this.setAbilities();
	}
}
