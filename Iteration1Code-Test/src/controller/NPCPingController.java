package controller;

import java.util.Observable;

import model.entity.Entity;
import model.entity.NPC;

public class NPCPingController{
	
	Entity entity;
	
	public NPCPingController (Entity entity) {
		this.entity = entity;
	}
	
	public void pingFoundAvatar () {
		System.out.println(entity+"says: My liege, we have found the avatar");
		if(!(entity.getPreferredState().isTriggered())) {
			System.out.println("triggering");
			entity.triggerPreferredState();
			System.out.println("triggered");
		}
	}
	
	public void pingInRangeOfTarget () {
		//System.out.println("In attacking range!");
	}
	
	public void pingOutOfRangeOfTarget () {
		//System.out.println("Drat, lost the target!");
	}
	
	public void pingRangeEstablished () {
		//System.out.println("Range established");
	}
}
