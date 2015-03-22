package view;

import java.awt.Color;

public class NullMapFlash extends MapFlash {

	public NullMapFlash() {
		setView();
	}
	
	@Override
	public Color getFlashColor() {
		// TODO Auto-generated method stub
		return new Color(0,0,0,0);
	}
	
	@Override
	public void setView() {
		super.setView();
		
	}

}
