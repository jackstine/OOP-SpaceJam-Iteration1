package model.visitor;

import model.items.AlchemistWeapon;
import model.items.Armor;
import model.items.Boots;
import model.items.Gloves;
import model.items.Helmet;
import model.items.HunterWeapon;
import model.items.Leggings;
import model.items.Projectile;
import model.items.Shield;
import model.items.TerminatorBrawling;
import model.items.TerminatorSingleWeapon;
import model.items.TerminatorTwoHandedWeapon;

public interface EquipableVisitor {
	public abstract void accept(Helmet helmet);
	public abstract void accept(Armor armor);
	public abstract void accept(Leggings leggings);
	public abstract void accept(Boots boots);
	public abstract void accept(Gloves gloves);
	public abstract void accept(Projectile projectile);
	public abstract void accept(Shield shield);
	public abstract void accept(HunterWeapon hunterWeapon);
	public abstract void accept(AlchemistWeapon alchemistWeapon);
	public abstract void accept(TerminatorSingleWeapon terminatorSingleWeapon);
	public abstract void accept(TerminatorTwoHandedWeapon terminatorTwoHandedWeapon);
	public abstract void accept(TerminatorBrawling terminatorBrawling);
}
