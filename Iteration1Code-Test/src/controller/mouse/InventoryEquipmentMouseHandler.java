package controller.mouse;

import java.awt.event.MouseEvent;

import utilities.Scaling;
import view.InventoryEquipmentView;
import model.Point;
import model.Entity.Avatar;
import model.items.TakeableItem;

public class InventoryEquipmentMouseHandler {
	private Avatar avatar;
	private InventoryEquipmentView equipmentView;
	
	public InventoryEquipmentMouseHandler(Avatar avatar, InventoryEquipmentView equipmentView){
		this.avatar = avatar;
		this.equipmentView = equipmentView;
	}
	
	private Point getInventorySlot(MouseEvent e){
		int x = e.getY()/Scaling.SLOT_VIEW_SCALE;
		int y = e.getX()/Scaling.SLOT_VIEW_SCALE;
		return new Point(x,y);
	}
	
	public void unequipItem(MouseEvent e){
		Point slotPoint = getInventorySlot(e);
		avatar.unequipInventorySlot(slotPoint);
	}
	
	public void useItem(MouseEvent e){
		Point pointOfSlot = this.getInventorySlot(e);
		//TODO CHANGE TO unequipSLOT()
		TakeableItem item = avatar.unequipInventorySlot(pointOfSlot);
		// we can make this better by calling on Avatar to perform an action on the point
		// avatar.useItemInInventory(point) and we will have this encapsulated
		boolean notEmpty = item != null;
		if (notEmpty){
			item.action(avatar);
		}
		equipmentView.repaint();
	}
	
	public TakeableItem unequipEquipmentSlot(MouseEvent e){
		int x = e.getX() / Scaling.EQUIPMENT_SLOT_WIDTH;
		int y = e.getY() / Scaling.EQUIPMENT_SLOT_HEIGHT;
		Point point = new Point(x,y);
		TakeableItem item = avatar.unequipEquipment(point);
		if (avatar.equipInventory(item)){
			avatar.unequipEquipment(point);
		}
		equipmentView.repaint();
		return item;
	}

}
