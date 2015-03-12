package model;

import model.Entity.Avatar;
import model.Entity.NPC;

public class NpcEffectHandler {
	private Avatar avatar;
	
	public NpcEffectHandler(Avatar avatar){
		
		this.avatar=avatar;
		
	}
	public void apply(NPC npc){
		
		npc.getAreaEffect().apply(avatar); 
	}
}
