package model.items;

import model.Avatar;
import model.EffectApplication;


public class HealingOneShotItem extends OneShotItem {

	private double percentHealth;
	
	public HealingOneShotItem(double percentHealth) {
		this.percentHealth = percentHealth;
	}
	
	public double getPercentHealth() {
		return this.percentHealth;
	}
	
	public void accept(ItemVisitor visitor){
		visitor.accept(this);
	}
	
	@Override
	public boolean action(Avatar avatar) {
		EffectApplication.apply(avatar, this);
		return true;
	}
	
	public String toString() {
		return "Item:HealingOneShotItem:" + this.percentHealth;
	}

	@Override
	public String getItemName() {
		// TODO Auto-generated method stub
		return null;
	}
}
