package view;

import java.awt.Color;

@SuppressWarnings("serial")
public class DealDamageMapFlash extends MapFlash {

	public DealDamageMapFlash() {
		setView();
	}
	
	@Override
	public Color getFlashColor() {
		// TODO Auto-generated method stub
		return new Color(255,255,255,120);
	}

}
