package testing;

import model.entity.Avatar;
import model.items.AlchemistWeapon;
import model.items.HunterWeapon;
import model.items.TerminatorSingleWeapon;
import model.items.TerminatorWeapon;
import model.items.Weapon;
import model.slots.Equipment;
import model.slots.TerminatorWeaponSlot;
import model.occupation.*;

public class EquipingTest {
	
	public static void equip(Weapon weapon,Occupation oc){
		Avatar avatar = new Avatar(oc);
		weapon.action(avatar);
	}
	
	public static void equipping (Weapon weapon){
		Occupation termOc = new Terminator();
		Occupation hunterOc = new Hunter();
		Occupation alchemistOc = new Alchemist();
		equip(weapon,termOc);
		equip(weapon,hunterOc);
		equip(weapon,alchemistOc);
	}
	
	public static void equippingAll(Occupation oc,Weapon weapon){
		TerminatorWeapon terminatorWeapon = new TerminatorSingleWeapon(5);
		HunterWeapon hunterWeapon = new HunterWeapon(10);
		AlchemistWeapon alchemistWeapon = new AlchemistWeapon(15);
		Avatar avatar = new Avatar(oc);
		weapon.action(avatar);
		System.out.print(avatar.getEquipment().getSlot(Equipment.WEAPON_SLOT) + "  ");
		terminatorWeapon.action(avatar);
		System.out.println();
		System.out.print(avatar.getEquipment().getSlot(Equipment.WEAPON_SLOT) + "  ");
		hunterWeapon.action(avatar);
		System.out.print(avatar.getEquipment().getSlot(Equipment.WEAPON_SLOT) + "  ");
		alchemistWeapon.action(avatar);
		System.out.print(avatar.getEquipment().getSlot(Equipment.WEAPON_SLOT) + "\n");
	}
	
	public static void main(String[] args){
		TerminatorWeapon terminatorWeapon = new TerminatorSingleWeapon(5);
		HunterWeapon hunterWeapon = new HunterWeapon(10);
		AlchemistWeapon alchemistWeapon = new AlchemistWeapon(15);
		equipping(terminatorWeapon);	// should be 5
		equipping(hunterWeapon);
		equipping(alchemistWeapon);
		// should be
		// 5   -1    -1
		// -1  10   -1
		// -1  -1    15
		
		equippingAll(new Terminator(),terminatorWeapon);  //  5   5   5
		equippingAll(new Hunter(),hunterWeapon);     //  10   10  10
		equippingAll(new Alchemist(),alchemistWeapon);  //  15   15  15
	}

}
