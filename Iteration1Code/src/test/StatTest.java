package Test;

import java.util.*;

import model.*;

public class StatTest {
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		PrimaryStat agility = new Agility(10);
		PrimaryStat experience = new Experience(0);
		PrimaryStat hardiness = new Hardiness(10);
		PrimaryStat intellect = new Intellect(10);
		PrimaryStat lives = new Lives(5);
		PrimaryStat movement = new Movement(1);
		PrimaryStat strength = new Strength(10);
		
		DerivedStat level = new Level();
		DerivedStat life = new Life();
		DerivedStat mana = new Mana();
		
		experience.addAllObservers(level);
		hardiness.addAllObservers(life);
		intellect.addAllObservers(mana);
		level.addAllObservers(life, mana);
		
		level.calculateValue();
		life.calculateValue();
		mana.calculateValue();
		
		while (true) {
			System.out.println("Primary Stats");
			System.out.println("\tAgility - " + agility.getValue());
			System.out.println("\tExperience - " + experience.getValue());
			System.out.println("\tHardiness - " + hardiness.getValue());
			System.out.println("\tIntellect - " + intellect.getValue());
			System.out.println("\tLives - " + lives.getValue());
			System.out.println("\tMovement - " + movement.getValue());
			System.out.println("\tStrength - " + strength.getValue());
			System.out.println("Derived Stats");
			System.out.println("\tLevel - " + level.getValue());
			System.out.println("\tLife - " + life.getValue());
			System.out.println("\tMana - " + mana.getValue());
			
			System.out.println();
			
			System.out.println("(1) Change agility");
			System.out.println("(2) Change experience");
			System.out.println("(3) Change hardiness");
			System.out.println("(4) Change intellect");
			System.out.println("(5) Change lives");
			System.out.println("(6) Change movement");
			System.out.println("(7) Change strength");
			System.out.println("(8) Quit");
			System.out.print("Choose: ");
			
			int t = in.nextInt();
			
			if (t == 1) {
				System.out.print("New agility: ");
				int a = in.nextInt();
				agility.update(a);
			} else if (t == 2) {
				System.out.print("New experience: ");
				int e = in.nextInt();
				experience.update(e);
			} else if (t == 3) {
				System.out.print("New hardiness: ");
				int h = in.nextInt();
				hardiness.update(h);
			} else if (t == 4) {
				System.out.print("New intellect: ");
				int i = in.nextInt();
				intellect.update(i);
			} else if (t == 5) {
				System.out.print("New lives: ");
				int l = in.nextInt();
				lives.update(l);
			} else if (t == 6) {
				System.out.print("New movement: ");
				int m = in.nextInt();
				movement.update(m);
			} else if (t == 7) {
				System.out.print("New strength: ");
				int s = in.nextInt();
				strength.update(s);
			} else if (t == 8) {
				break;
			}
			
			System.out.println("----------------------------");
		}
	}

}
