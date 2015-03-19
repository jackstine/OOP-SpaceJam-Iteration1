package controller.mouse;

import java.awt.event.MouseEvent;

import utilities.Scaling;
import view.InventoryEquipmentView;
import model.Point;
import model.entity.Avatar;
import model.items.TakeableItem;
import model.slots.InventorySlot;

public class InventoryEquipmentMouseHandler {
	private Avatar avatar;
	private InventoryEquipmentView inventoryEquipmentView;
	private InventorySlot draggingSlot = new InventorySlot();
	
	public InventoryEquipmentMouseHandler(Avatar avatar, InventoryEquipmentView inventoryEquipmentView){
		this.avatar = avatar;
		this.inventoryEquipmentView = inventoryEquipmentView;
	}
	
	public Point getInventorySlot(MouseEvent e){
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
		inventoryEquipmentView.repaint();
	}
	
	public TakeableItem unequipEquipmentSlot(MouseEvent e){
		int x = e.getX() / Scaling.EQUIPMENT_SLOT_WIDTH;
		int y = e.getY() / Scaling.EQUIPMENT_SLOT_HEIGHT;
		Point point = new Point(x,y);
		TakeableItem item = avatar.unequipEquipment(point);
		if (avatar.equipInventory(item)){
			avatar.unequipEquipment(point);
		}
		inventoryEquipmentView.repaint();
		return item;
	}
	
	public void dragItem(MouseEvent e){
		if (draggingSlot.has()){
			this.inventoryEquipmentView.setDraggingSlotPoint(this.getDraggingSlotPoint(e));
		}
		else{
			TakeableItem itemPressed = avatar.unequipInventorySlot(this.getInventorySlot(e));
			if (itemPressed != null){
				draggingSlot.equip(itemPressed);
				inventoryEquipmentView.setDraggingSlotPoint(this.getDraggingSlotPoint(e));
				inventoryEquipmentView.setDraggingSlot(draggingSlot);
			}
		}
		this.inventoryEquipmentView.repaintInventoryView();
	}
	
	public Point getDraggingSlotPoint(MouseEvent e){
		int pointX = e.getX() - (Scaling.SLOT_VIEW_WIDTH/2);
		int pointY = e.getY() - (Scaling.SLOT_VIEW_HEIGHT/2);
		return new Point(pointX,pointY);
	}
	
	public void releaseItem(MouseEvent e){
		if (draggingSlot != null){
			TakeableItem item = draggingSlot.unequip();
			Point point = this.getInventorySlot(e);
			boolean itemNotEquipped = ! avatar.equipInventory(item,point);
			if (itemNotEquipped){
				avatar.equipInventory(item);
			}
		}
		this.inventoryEquipmentView.repaintInventoryView();
	}

}
