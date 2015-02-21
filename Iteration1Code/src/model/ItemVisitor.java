package model;

public interface ItemVisitor {
	public void accept(Armor a);
	public void accept(Weapon w);
	public void accept(GiantRock g);
	public void accept(HealingOneShotItem h);
	public void accept(DamagingOneShotItem d);
	public void accept(TreasureChest t);
}
