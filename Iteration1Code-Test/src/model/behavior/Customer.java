package model.behavior;

import model.entity.Entity;

public class Customer implements Behavior{
	private Entity customer;
	
	public Customer(Entity entity){
		this.customer = entity;
	}

	//the receiver is usually a barter, but does not have to be
	public void perform(Entity receiver) {
		System.out.println("CUSTOMER IS BYING CALLED");
		customer.setBuyingMode();
		customer.setSellingPartner(receiver);
	}

	public void getBuffs() {
	}

	public void kill() {
		customer.resetBuyingMode();
		customer.resetSellingPartner();
	}

}
