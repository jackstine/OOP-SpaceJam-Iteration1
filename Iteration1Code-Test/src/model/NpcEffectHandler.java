package model;

import model.Entity.Avatar;
import model.Entity.Entity;
import model.Entity.Merchant;
import model.Entity.NPC;
import model.Entity.Orc;
import model.Entity.Skeleton;
//import view.MerchantView;

public class NpcEffectHandler {
	private Avatar avatar;
	
	
	public NpcEffectHandler(Avatar avatar){
		
		this.avatar=avatar;
		
	}
	public void apply(Entity npc,Location avatarLocation){
		
		
		
		// Let us now begin the Satan Ceremony
		if(npc!=null && npc instanceof Orc){
			//if(Integer.parseInt(avatar.getStat("Level"))>1){
			
			npc.getAreaEffect().apply(avatar); 
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
		
		else if(npc!=null && npc instanceof Skeleton){
			//if(Integer.parseInt(avatar.getStat("Level"))>1){
			
			
					int x,y;
					x=avatarLocation.getX();
					y=avatarLocation.getY();
					//System.out.println(x + " " + y);
					if(x==8 && y ==12)
					{
						npc.setState(1);
					}
					else if(x==9 && y==11)
					{
						npc.setState(2);
					}
					else if(x==9 && y==13)
					{
						npc.setState(3);
					}
					else if(x==10 && y==12)
					{
						npc.setState(4);
					}
					//npc.action(avatar);
					//tile.setItem(it);
				}
		
		else if(npc!=null && npc instanceof Merchant){
			//if(Integer.parseInt(avatar.getStat("Level"))>1){
			
//					MerchantView mv=new MerchantView();
//					mv.setVisible(true);
					//npc.action(avatar);
					//tile.setItem(it);
				}
			//}
	}
	
	
}
