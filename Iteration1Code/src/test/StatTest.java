package test;

import java.util.*;

import model.*;

public class StatTest {
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		PrimaryStat hardiness = new Hardiness(10);
		PrimaryStat lives = new Lives(2);
		PrimaryStat experience = new Experience(0);
		
		DerivedStat level = new Level();
		DerivedStat life = new Life();
		
		hardiness.addAllObservers(life);
		experience.addAllObservers(level);
		level.addAllObservers(life);
		
		level.calculateValue();
		life.calculateValue();
		
		while (true) {
			System.out.println("Primary Stats");
			System.out.println("\tHardiness - " + hardiness.getValue());
			System.out.println("\tLives - " + lives.getValue());
			System.out.println("\tExperience - " + experience.getValue());
			System.out.println("Derived Stats");
			System.out.println("\tLevel - " + level.getValue());
			System.out.println("\tLife - " + life.getValue());
			
			System.out.println();
			
			System.out.println("(1) Change hardiness");
			System.out.println("(2) change lives");
			System.out.println("(3) Change experience");
			System.out.println("(4) Quit");
			System.out.print("Choose: ");
			int t = in.nextInt();
			if (t == 1) {
				System.out.print("New hardiness: ");
				int h = in.nextInt();
				hardiness.update(h);				
			} else if (t == 2) {
				System.out.print("New lives: ");
				int l = in.nextInt();
				lives.update(l);
			}else if (t == 3) {
				System.out.println("New experience: ");
				int e = in.nextInt();
				experience.update(e);
			} else if (t == 4) {
				break;
			}
			System.out.println("----------------------------");
		}
	}

}
