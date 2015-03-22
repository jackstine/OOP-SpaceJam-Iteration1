package model.behavior;

import utilities.Directions;
import utilities.Scaling;
import view.MerchantView;
import model.GameLog;
import model.entity.Entity;

public class Barter implements Behavior{
	
	private MerchantView mvc;
	private Entity barter;
	
	public Barter(Entity barter){
		this.barter = barter;
		this.mvc=new MerchantView();
		mvc.setBounds(Scaling.MERCHANTVIEW_X , Scaling.MERCHANTVIEW_Y, Scaling.MERCHANTVIEW_WIDTH, Scaling.MERCHANTVIEW_HEIGHT);
	}

	public void perform(Entity receiver) {
		//barter.writeJournal(receiver.getDialogue());
		GameLog.writeToLog(barter.getDialogue());
		int oppositeDirection = Directions.getOppositeDirection(receiver.getDirection());
		barter.setDirection(oppositeDirection);
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
