package model.Entity;

import model.AreaEffect;

public class Orc extends NPC {
	protected AreaEffect effect;
	public Orc(AreaEffect effect) {
		super("Orc");
		// TODO Auto-generated constructor stub
		this.effect=effect;
	}

	public String toString(){
		return "I AM A ORC";
		
	}
	public AreaEffect getAreaEffect() {
		return this.effect;
	}
}
