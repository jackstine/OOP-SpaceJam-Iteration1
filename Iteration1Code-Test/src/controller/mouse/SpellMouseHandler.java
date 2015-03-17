package controller.mouse;

import java.awt.event.MouseEvent;

import model.Point;
import model.Entity.Avatar;
import utilities.Scaling;
import view.SpellView;

public class SpellMouseHandler {
	private SpellView spellView;
	private Avatar avatar;
	private Point spellSelected;
	
	public SpellMouseHandler(SpellView spellView,Avatar avatar){
		this.spellView = spellView;
		this.avatar = avatar;
	}
	
	public Point getSelected(){
		return this.spellSelected;
	}
	
	public void selectSpell(MouseEvent e){
		int pointX = e.getX() / Scaling.SPELL_SPACE_X;
		int pointY = (e.getY() - Scaling.SPELL_OFFSET_Y) / Scaling.SPELL_SPACE_Y;
		Point spellToBeSelected = new Point(pointX,pointY);
		
		boolean spellSelectedIsEqualTo = spellSelected.equals(spellToBeSelected);
		boolean spellSelectedInRange = pointY < Scaling.SPELLS_HEIGHT_NUM;
		boolean spellSelectedExist = spellSelected != null;

		if (spellSelectedExist){
			if (spellSelectedIsEqualTo){
				spellSelected = null;
			}
		}
		else if(spellSelectedInRange){
			spellSelected = spellToBeSelected;
			avatar.setSelectedSpell(spellSelected);
		}
		this.spellView.repaint();
	}

}
