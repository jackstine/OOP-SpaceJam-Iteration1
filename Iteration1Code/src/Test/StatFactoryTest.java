package Test;

import java.util.Collection;
import java.util.Map;

import model.Stat;
import model.StatFactory;

public class StatFactoryTest {
	StatFactory sf = new StatFactory();
	Map map = sf.initializeStats();
	
	Collection col = map.values();
	
	for (Stat s : col) {
		System.out.println(s.getClass().toString());
	}
}
