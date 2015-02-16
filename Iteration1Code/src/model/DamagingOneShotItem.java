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
	public boolean action(Avatar avatar) {
		EffectApplication.apply(avatar, this);		
		return true;
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
	
	public String toString() {
		return "Item:DamagingOneShotItem:" + this.percentDamage;
	}

	@Override
	public String getItemName() {
		// TODO Auto-generated method stub
		return null;
	}
}
