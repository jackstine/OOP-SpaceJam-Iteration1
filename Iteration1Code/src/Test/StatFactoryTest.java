package Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import model.AlchemistStatFactory;
import model.HunterStatFactory;
import model.Stat;
import model.StatFactory;

public class StatFactoryTest {
	public static void main(String[] args) {
		StatFactory sf = new HunterStatFactory();
		Map map = sf.initializeStats();
		
		List<Stat> list = new ArrayList<Stat>(map.values());
		
		for (Stat s: list) {
			System.out.println(s);
		}

	
	}
}
