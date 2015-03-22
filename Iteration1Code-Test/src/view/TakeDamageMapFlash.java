package view;

import java.awt.Color;

@SuppressWarnings("serial")
public class TakeDamageMapFlash extends MapFlash {

	public TakeDamageMapFlash() {
		setView();
	}
	
	@Override
	public Color getFlashColor() {
		// TODO Auto-generated method stub
		return new Color(255,0,0,120);
	}

}
