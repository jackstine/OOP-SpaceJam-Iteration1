package model;

import java.io.Serializable;
import java.util.Map;

public abstract class Occupation implements Serializable{
	
	public abstract void attack();
	public abstract void useAbiltiy();
	public abstract Map<String, Stat> createStats();
	
}
