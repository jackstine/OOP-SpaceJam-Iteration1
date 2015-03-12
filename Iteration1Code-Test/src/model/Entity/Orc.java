package model.Entity;

import model.AreaEffect;
import model.DamageAreaEffect;

public class Orc extends NPC {
	protected AreaEffect effect;
	protected AreaEffect effect1=new DamageAreaEffect(0.0);
	protected int count=100;
	public Orc(AreaEffect effect) {
		super("Orc");
		// TODO Auto-generated constructor stub
		this.effect=effect;
	}

	public String toString(){
		return "I AM A ORC";
		
	}
	public AreaEffect getAreaEffect() {
		if(count>=0){
		count=count-10;
		System.out.println("Health of ORC is: "+count);
		return this.effect;
		}
		else{
			return effect1;
		}
	}
}
