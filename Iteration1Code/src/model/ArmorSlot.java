package model;


public class ArmorSlot extends BufferSlot{
    
	public ArmorSlot(DerivedStat armorRating){
    	this.addObserver(armorRating);
    }
    
	public ArmorSlot(){}

	public boolean equip(Weapon item) {
		return false;
	}
	public boolean equip(Armor armor) {
		return this.equipItem(armor);
	}
	
	public String toString(){
		if (this.has()) return "Item:Armor:" + this.bonus;
		else return "Item:Armor:-1";
	}

    public static void main(String[] args){
        ArmorSlot slot = new ArmorSlot();
        Armor armor = new Armor(15);
        slot.equip(armor);
        System.out.println(slot);
        slot.unequip();
        System.out.println(slot);
    }
}
