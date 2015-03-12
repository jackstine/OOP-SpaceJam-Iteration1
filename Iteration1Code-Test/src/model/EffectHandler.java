package model;

import model.Entity.Avatar;
import model.Entity.NPC;
import model.items.HealingOneShotItem;
import model.items.Item;

public class EffectHandler {
	//private Tile tile;
	//GameMap map;
	//AreaEffect effect;
	private Avatar avatar;
	
	public EffectHandler(Avatar avatar){
		this.avatar=avatar;
	}
	
	//need to find out how to fix this.
	public void apply(Tile tile){
		//tile.getDecal().getAreaEffect().apply(avatar);
		//TrapDamageApplication.apply(avatar,tile.getTrap());
		
		
		
		Decal decal=tile.getDecal();
		Item item =  tile.getItem(); 
		Trap trap= tile.getTrap();
		
		if(decal!=null){
			decal.getAreaEffect().apply(avatar); 
			}
		if(item!=null && item instanceof HealingOneShotItem){
			item.action(avatar); //add effect after getting clicked /add this
			tile.setItem(null);
		}
		if(tile.getTrap()!=null)
		TrapDamageApplication.apply(avatar,tile.getTrap());
		
	}
	
	

}
