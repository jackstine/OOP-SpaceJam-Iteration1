package model.Entity;

import java.util.Random;

import model.AreaEffect;

public class Skeleton extends NPC implements Conversable {
	protected AreaEffect effect;
	public Skeleton(AreaEffect effect) {
		super("Skeleton");
		this.effect=effect;
		// TODO Auto-generated constructor stub
	}

	@Override
	public AreaEffect getAreaEffect() {
		// TODO Auto-generated method stub
		return this.effect;
	}
	
	public int randNo()
	{
		int x;
		Random rand=new Random();
		x=rand.nextInt();
		return x;
	}

	@Override
	public String getDialogue() {
		// TODO Auto-generated method stub
		return "Skeleton: I'M A SCARY SKELETON RAAWWRRR";
	}

}
