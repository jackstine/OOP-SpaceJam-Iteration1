package model.Entity;

public class EntityEffectHandler {
	//TODO well I am not obeying the Tell Dont ask principle here
	// and the LoD
	
	
	public static void applyDamage(Entity entity,int damage){
		entity.getStats().subHP(damage);
	}
	
	public static void applyHeal(Entity entity, int heal){
		entity.getStats().addHP(heal);
	}

}
