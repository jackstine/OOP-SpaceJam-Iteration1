package model.items;

import model.Avatar;


public interface Item{
	public boolean action(Avatar avatar);
	
	public void accept(ItemVisitor visitor);
	
	public String getItemName();
}

