package model;

import java.util.Map;

public abstract class Occupation {
	
	public abstract void attack();
	public abstract void useAbiltiy();
	public abstract Map<String, Stat> createStats();
	
}
