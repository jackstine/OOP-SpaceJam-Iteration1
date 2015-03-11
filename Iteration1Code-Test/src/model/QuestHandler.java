package model;

import model.Entity.Avatar;
import model.items.Item;
import model.items.TreasureChest;

public class QuestHandler {
private Avatar avatar;
	
	public QuestHandler(Avatar avatar){
		this.avatar=avatar;
	}
	
	public void apply(Tile tile){
		Item it= tile.getItem();
		// Let us now begin the Satan Ceremony
		if(it!=null && it instanceof TreasureChest){
			if(Integer.parseInt(avatar.getStat("Level"))>1){
					it.action(avatar);
					tile.setItem(it);
				}
			}
		}
}
