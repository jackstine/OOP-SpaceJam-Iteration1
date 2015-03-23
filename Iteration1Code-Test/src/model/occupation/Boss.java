package model.occupation;

import model.items.equipment.EquipmentBuilder;
import model.slots.Equipment;
import model.stats.factory.BossStatFactory;
import model.stats.factory.StatFactory;
import model.visitor.OccupationVisitor;
import utilities.SpriteSheetUtility;

public class Boss extends Terminator{
	
	protected StatFactory getStatFactory(Equipment equipment){
		return new BossStatFactory(equipment);
	}
	public Equipment createEquipment(EquipmentBuilder eb){
		return eb.buildEquipmentTerminatorNPC(this);
	}
	public SpriteSheetUtility getSpriteSheet(){
		return new SpriteSheetUtility(this);
	}
	
	@Override
	public void accept(OccupationVisitor visitor) {
		// TODO Auto-generated method stub
		
	}
	
}
