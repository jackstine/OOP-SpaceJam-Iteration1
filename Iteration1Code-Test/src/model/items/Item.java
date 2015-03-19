package model.items;

import model.entity.Avatar;
import model.visitor.ItemVisitor;


public interface Item{
	public boolean action(Avatar avatar);
	
	public void accept(ItemVisitor visitor);
	
	public String getItemName();
}

