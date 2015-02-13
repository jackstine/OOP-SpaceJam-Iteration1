package model;

import java.util.Map;

public class Alchemist extends Occupation{
	
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
