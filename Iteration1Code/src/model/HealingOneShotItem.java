package model;

import java.awt.image.BufferedImage;

public class HealingOneShotItem extends OneShotItem {

	private double percentHealth;
	
	public HealingOneShotItem(double percentHealth) {
		this.percentHealth = percentHealth;
	}
	
	public double getPercentHealth() {
		return this.percentHealth;
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
}
