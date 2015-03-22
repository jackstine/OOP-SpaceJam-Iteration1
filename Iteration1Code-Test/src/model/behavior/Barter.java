package model.behavior;

import utilities.Directions;
import utilities.Scaling;
import view.MerchantView;
import model.GameLog;
import model.entity.Entity;

public class Barter implements Behavior{
	
	private MerchantView mvc;
	private Entity barter;
	private Entity receiver;
	
	public Barter(Entity barter){
		this.barter = barter;
		this.mvc=new MerchantView(barter);
		mvc.setBounds(Scaling.MERCHANTVIEW_X , Scaling.MERCHANTVIEW_Y, Scaling.MERCHANTVIEW_WIDTH, Scaling.MERCHANTVIEW_HEIGHT);
	}

	public void perform(Entity receiver) {

		//barter.writeJournal(receiver.getDialogue());
		GameLog.writeToLog(barter.getDialogue());

		this.receiver = receiver;

		int oppositeDirection = Directions.getOppositeDirection(receiver.getDirection());
		barter.setDirection(oppositeDirection);
		this.setMVC(receiver);
		this.mvc.showMerchantView();
		Customer customerBehavior = new Customer(receiver);
		receiver.setEngageBehavior(customerBehavior);
		receiver.engage(barter);
	}

	
	public void setMVC(Entity entity){
		this.mvc.setEntity(entity);
	}
	
	public void getBuffs() {}

	public void kill() {
		barter.revertEngageBehavior();
	}

}
