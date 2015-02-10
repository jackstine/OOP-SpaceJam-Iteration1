package Test;
import model.Armor;
import model.ArmorRating;
import model.Equipment;
import model.OffensiveRating;
import model.Weapon;

public class TestEquipment {
    public static void main(String[] args){
    	OffensiveRating off = new OffensiveRating();
    	ArmorRating def = new ArmorRating();
    	System.out.println(def+"    "+off);		// 0    0
    	Equipment equipment = new Equipment(def,off);
    	Armor armor = new Armor(15);
    	Weapon weapon = new Weapon(100);
    	equipment.equipArmor(armor);
    	System.out.println(def+"    "+off);	//  15    0
    	equipment.unequipArmor();
    	System.out.println(def+"    "+off); //  0     0
    	equipment.equipWeapon(weapon);
    	System.out.println(def+"    "+off);//  0      100
    	equipment.equipArmor(armor);
    	System.out.println(def+"    "+off);// 15      100
    	equipment.unequipWeapon();
    	System.out.println(def+"    "+off);// 15       0
    }
}
