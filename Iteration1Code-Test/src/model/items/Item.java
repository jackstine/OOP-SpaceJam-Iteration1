package model.items;

import model.Entity.Avatar;
import model.visitor.ItemVisitor;


public interface Item{
	public boolean action(Avatar avatar);
	
	public void accept(ItemVisitor visitor);
	
	public String getItemName();
}

