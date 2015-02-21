package model;


public class DamagingOneShotItem extends OneShotItem {

	private double percentDamage;
	
	
	public DamagingOneShotItem(double percentDamage) {
		this.percentDamage = percentDamage;
	}
	
	public double getPercentDamage() {
		return this.percentDamage;
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
		return "Item:DamagingOneShotItem:" + this.percentDamage;
	}

	@Override
	public String getItemName() {
		// TODO Auto-generated method stub
		return null;
	}
}
