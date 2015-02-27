package testing;

import model.Avatar;
import model.items.AlchemistWeapon;
import model.items.HunterWeapon;
import model.items.TerminatorWeapon;
import model.items.Weapon;
import model.slots.Equipment;
import model.slots.TerminatorWeaponSlot;
import model.occupation.*;

public class EquipingTest {
	
	public static void equip(Weapon weapon,Occupation oc){
		Avatar avatar = new Avatar(oc);
		weapon.action(avatar);
		System.out.print(avatar.getEquipment().getSlot(Equipment.WEAPON_SLOT) + "  ");
	}
	
	public static void equipping (Weapon weapon){
		Occupation termOc = new Terminator();
		Occupation hunterOc = new Hunter();
		Occupation alchemistOc = new Alchemist();
		equip(weapon,termOc);
		equip(weapon,hunterOc);
		equip(weapon,alchemistOc);
		System.out.println();
	}
	
	public static void main(String[] args){
		TerminatorWeapon terminatorWeapon = new TerminatorWeapon(5);
		HunterWeapon hunterWeapon = new HunterWeapon(10);
		AlchemistWeapon alchemistWeapon = new AlchemistWeapon(15);
		equipping(terminatorWeapon);	// should be 5
		equipping(hunterWeapon);
		equipping(alchemistWeapon);
		// should be
		// 5   -1    -1
		// -1  10   -1
		// -1  -1    15
	}

}
