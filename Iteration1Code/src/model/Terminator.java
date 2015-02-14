package model;

import java.io.Serializable;
import java.util.Map;

public class Terminator extends Occupation implements Serializable{

	public Terminator() {
		portraitLocation = "src/res/img/terminator_portrait.jpg";
	}
	
	public void attack() {
		// TODO Auto-generated method stub
		
	}

	public void useAbiltiy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Map<String, Stat> createStats() {
		StatFactory statFactory = new TerminatorStatFactory();
		return statFactory.initializeStats();
	}

}
