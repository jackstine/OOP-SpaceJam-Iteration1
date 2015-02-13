package model;

import java.awt.image.BufferedImage;

public class DamagingOneShotItem extends OneShotItem {

	private double percentDamage;
	
	public DamagingOneShotItem(double percentDamage) {
		this.percentDamage = percentDamage;
	}
	
	public double getPercentDamage() {
		return this.percentDamage;
	}
	
	@Override
	public void action(Entity entity) {
		EffectApplication.apply(entity, this);		
	}
	
	@Override
	public BufferedImage getImage(int scale) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getImagePath() {
		// TODO Auto-generated method stub
		return null;
	}	

}
