package model;

import model.entity.Avatar;
import model.items.Item;
import model.visitor.ItemQuestVisitor;

public class QuestHandler {
	private Avatar avatar;
	private ItemQuestVisitor visitor = new ItemQuestVisitor();
	
	public QuestHandler(Avatar avatar){
		this.avatar=avatar;
		visitor.setAvatar(this.avatar);
	}
	
	public void apply(Tile tile){
		visitor.setTile(tile);
		Item it= tile.getItem();
		
		Decal decal=tile.getDecal();
		Item item =  tile.getItem(); 
		Trap trap= tile.getTrap();
		
		if(decal!=null){
			//violation of LoD
			decal.getAreaEffect().apply(avatar); 
		}

		// Let us now begin the Satan Ceremony
		boolean itemExist = it != null;
		if (itemExist){
			it.accept(this.visitor);
		}
		
		if(tile.getTrap()!=null) trap.apply(avatar);
		
	}
	

}
