package model.visitor;

import model.items.AlchemistWeapon;
import model.items.Armor;
import model.items.Boots;
import model.items.DamagingOneShotItem;
import model.items.GiantRock;
import model.items.Gloves;
import model.items.HealingOneShotItem;
import model.items.Helmet;
import model.items.HunterWeapon;
import model.items.Leggings;
import model.items.Projectile;
import model.items.Shield;
import model.items.TerminatorBrawling;
import model.items.TerminatorSingleWeapon;
import model.items.TerminatorTwoHandedWeapon;
import model.items.TreasureChest;


public interface ItemVisitor {
	public void accept(Armor a);
	public void accept(TerminatorSingleWeapon w);
	public void accept(TerminatorTwoHandedWeapon thw);
	public void accept(AlchemistWeapon a);
	public void accept(HunterWeapon h);
	public void accept(GiantRock g);
	public void accept(HealingOneShotItem h);
	public void accept(DamagingOneShotItem d);
	public void accept(TreasureChest t);
	public void accept(Gloves gloves);
	public void accept(Leggings leggings);
	public void accept(Shield shield);
	public void accept(Helmet helmet);
	public void accept(Boots boots);
	public void accept(Projectile projectile);
	public void accept(TerminatorBrawling terminatorBrawling);
}
