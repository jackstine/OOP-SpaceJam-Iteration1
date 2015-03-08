package model;

public class TrapDamageApplication {
	
	
	public static void apply(Entity entity, Trap trap){
		System.out.println("THIS RUNS");
		entity.setStatValue("HP",(int)(entity.getStatValue("HP") - trap.getDamage())); 
	}
}
