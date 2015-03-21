package model.behavior;

import utilities.Directions;
import utilities.Scaling;
import view.MerchantView;
import model.entity.Entity;

public class Barter implements Behavior{
	
	private MerchantView mvc;
	private Entity entity;
	
	public Barter(Entity entity){
		this.entity = entity;
		this.mvc=new MerchantView();
		mvc.setBounds(Scaling.MERCHANTVIEW_X , Scaling.MERCHANTVIEW_Y, Scaling.MERCHANTVIEW_WIDTH, Scaling.MERCHANTVIEW_HEIGHT);
	}

	public void perform(Entity initiate, Entity receiver) {
		initiate.writeJournal(receiver.getDialogue());
		int oppositeDirection = Directions.getOppositeDirection(receiver.getDirection());
		initiate.setDirection(oppositeDirection);
		this.setMVC(receiver);
		this.mvc.showMerchantView();
	}

	
	public void setMVC(Entity entity){
		this.mvc.setEntity(entity);
	}
	
	public void getBuffs() {}

	public void kill() {
	}

}
