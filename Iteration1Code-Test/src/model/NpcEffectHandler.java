package model;

import model.Entity.Avatar;
import model.Entity.NPC;
import model.Entity.Orc;
import model.items.Item;
import model.items.TreasureChest;

public class NpcEffectHandler {
	private Avatar avatar;
	
	
	public NpcEffectHandler(Avatar avatar){
		
		this.avatar=avatar;
		
	}
	public void apply(NPC npc,Location avatarLocation){
		
		npc.getAreaEffect().apply(avatar); 
		
		// Let us now begin the Satan Ceremony
		if(npc!=null && npc instanceof Orc){
			//if(Integer.parseInt(avatar.getStat("Level"))>1){
			
			
					int x,y;
					x=avatarLocation.getX();
					y=avatarLocation.getY();
					//System.out.println(x + " " + y);
					if(x==13 && y ==12)
					{
						npc.setState(1);
					}
					else if(x==14 && y==11)
					{
						npc.setState(2);
					}
					else if(x==14 && y==13)
					{
						npc.setState(3);
					}
					//npc.action(avatar);
					//tile.setItem(it);
				}
			//}
	}
	
	
}
