package model.Entity;

import utilities.SpriteSheetUtility;
import model.AreaEffect;
import model.DamageAreaEffect;

public class Orc extends NPC {
	protected AreaEffect effect;
	protected AreaEffect effect1=new DamageAreaEffect(0.0);
	protected int hp=100;
	
	public Orc(AreaEffect effect) {
		super();
		// TODO Auto-generated constructor stub
		this.effect=effect;
	}

	public String toString(){
		return "I AM AN ORC";
	}
	
	public SpriteSheetUtility getSpriteSheet() {
		return new SpriteSheetUtility(this);
	}
	
	public AreaEffect getAreaEffect() {
		if(hp>=0){
			hp -= 10;
			System.out.println("Health of ORC is: " + hp);
			return this.effect;
		}
		else{
			return effect1;
		}
	}
	
}
