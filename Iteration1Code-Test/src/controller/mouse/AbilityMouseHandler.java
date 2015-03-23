package controller.mouse;

import java.awt.event.MouseEvent;

import model.Point;
import model.entity.Avatar;
import model.entity.Entity;
import utilities.Scaling;
import view.SpellView;
import view.AbilityView;

public class AbilityMouseHandler {
	private AbilityView abilityView;
	private Entity avatar;
	private Point abilitySelected;
	
	public AbilityMouseHandler(AbilityView abilityView,Entity avatar){
		this.abilityView = abilityView;
		this.avatar = avatar;
	}
	
	public Point getSelected(){
		return this.abilitySelected;
	}
	
	public void selectSpell(MouseEvent e){
		int pointX = e.getX() / Scaling.SPELL_SPACE_X;
		int pointY = (e.getY() - Scaling.SPELL_OFFSET_Y) / Scaling.SPELL_SPACE_Y;
		Point abilityToBeSelected = new Point(pointX,pointY);
		
		boolean abilitySelectedInRange = pointY < this.abilityView.getYRange();
		boolean abilitySelectedExist = abilitySelected != null;
		if (abilitySelectedExist){
			boolean abilitySelectedIsEqualTo = abilitySelected.equals(abilityToBeSelected);
			if (abilitySelectedIsEqualTo){
				abilitySelected = null;
				avatar.setSelectedSpell(null);
			} else{
				abilitySelected = abilityToBeSelected;
				avatar.setSelectedSpell(abilitySelected);
			}
		}
		else if(abilitySelectedInRange){
			abilitySelected = abilityToBeSelected;
			avatar.setSelectedSpell(abilitySelected);
		}
		this.abilityView.repaint();
	}

}
