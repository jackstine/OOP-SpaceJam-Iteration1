package model;

public class EffectHandler {
	//private Tile tile;
	//GameMap map;
	//AreaEffect effect;
	private Avatar avatar;
	
	public EffectHandler(Avatar avatar){
		this.avatar=avatar;
	}
	
	public void apply(Tile tile){
		Decal decal=tile.getDecal();
		Item item =  tile.getItem(); 
		if(decal!=null){
			decal.getAreaEffect().apply(avatar); 
			}
		if(item!=null && item instanceof HealingOneShotItem){
			item.action(avatar); //add effect after getting clicked /add this
			tile.setItem(null);
		}
		
		
	}
	

}
