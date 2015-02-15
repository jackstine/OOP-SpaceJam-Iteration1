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
		HealingOneShotItem item = (HealingOneShotItem) tile.getItem(); //casting
		if(decal!=null){
			decal.getAreaEffect().apply(avatar);
			tile.setDecal(null);
		}
		if(item!=null){
			item.action(avatar);
			tile.setItem(null);
		}
		
		
	}
	

}
