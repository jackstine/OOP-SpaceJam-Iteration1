package model.spells;

import utilities.Scaling;
import model.Point;
import model.entity.Entity;
import model.spells.Spellable;

public class Spells {
	// this class contains the spells that will be used by the Alchemist
	// this is the model, so that we can link the view with the model through the controller
	
	private Entity entity;
	private Point selectedSpell;
	
	private final Spellable[][] spells= new Spellable[Scaling.SPELLS_WIDTH_NUM][Scaling.SPELLS_HEIGHT_NUM];
	
	public Spells(Entity entity){
		this.entity = entity;
		this.setSpells();
	}
	
	private void setSpells(){
		//TODO get rid of these magic numbers once we get this class on the go
		//spells[0][0] = new FireSpell(this.entity);
		spells[0][0] =new BuffSpell(this.entity,100,"Movement");
		spells[0][1] = new EarthSpell(this.entity);
		spells[0][2] = new PlasmaRay(this.entity);
		spells[2][0] = new GloryHeal(this.entity);
		spells[2][1] = new ManaBuff(this.entity);
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

}
