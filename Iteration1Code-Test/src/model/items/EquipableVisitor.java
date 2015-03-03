package model.items;

public interface EquipableVisitor {
	public abstract void accept(Helmet helmet);
	public abstract void accept(Weapon weapon);
	public abstract void accept(Armor armor);
	public abstract void accept(Leggings leggings);
	public abstract void accept(Boots boots);
	public abstract void accept(Gloves gloves);
	public abstract void accept(Projectile projectile);
	public abstract void accept(Shield shield);
}
