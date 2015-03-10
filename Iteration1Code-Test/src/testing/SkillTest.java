package testing;

import model.*;
import model.occupation.*;
import java.util.*;

public class SkillTest {

	public static void main(String[] args) {
		
		Occupation alchemist = new Alchemist();
		Occupation hunter = new Hunter();
		Occupation terminator = new Terminator();
		
		alchemist.createNecessities();
		hunter.createNecessities();
		terminator.createNecessities();
		
		printSkills(terminator);
	}
	
	public static void printSkills(Occupation occupation) {
		Map<String, Skill> map = occupation.getSkills();
		for (String key : map.keySet()) System.out.println(map.get(key));
	}

}
