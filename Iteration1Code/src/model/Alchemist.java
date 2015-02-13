package model;

import java.io.Serializable;
import java.util.Map;

public class Alchemist extends Occupation implements Serializable{
	
	public void attack() {
		// TODO Auto-generated method stub
		
	}

	public void useAbiltiy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Map<String, Stat> createStats() {
		StatFactory statFactory = new AlchemistStatFactory();
		return statFactory.initializeStats();
	}

}
