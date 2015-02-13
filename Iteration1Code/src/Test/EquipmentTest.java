package Test;

import java.awt.Dimension;

import javax.swing.JFrame;

import model.Armor;
import model.Equipment;
import model.Weapon;
import view.EquipmentView;


public class EquipmentTest {

	public static void main(String[] args){
		JFrame f = new JFrame();
		f.setSize(new Dimension(1400,800));
		f.setPreferredSize(new Dimension(1400, 800));
		
		
		Equipment equipment = new Equipment();
		EquipmentView equipmentView = new EquipmentView(equipment);
		
		f.add(equipmentView);
        f.pack();
        f.repaint();
        f.setVisible(true);
        try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Armor armor = new Armor(10);
		Weapon weapon = new Weapon(10);
		equipment.equipArmor(armor);
		equipment.equipWeapon(weapon);
        
        f.repaint();
        try {
			Thread.sleep(1000);
			equipment.unequipArmor();
			f.repaint();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
	}
}
