package model;

public interface Slotable<T extends Item>{
	
	public boolean has();
    public T unequip();
    public T get();
    public <K extends T> boolean equip(K item);
}
 