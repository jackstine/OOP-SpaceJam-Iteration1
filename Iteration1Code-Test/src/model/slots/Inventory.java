package model.slots;

import model.Point;
import model.items.TakeableItem;
import model.items.Weapons;

public class Inventory extends SlotContainer{
    public static final int COL = 6;
    public static final int ROW = 5;
    protected InventorySlot[][] items;    

    public Inventory(){
        setItems();
    }

    private void setItems(){
        this.items = new InventorySlot[ROW][COL];
        for (int i = 0; i < ROW; i++){
            for (int j = 0; j < COL; j++){
                this.items[i][j] = new InventorySlot();
            }
        }
        this.items[0][0].equip(Weapons.DAVESWORD.weapon);
        this.items[0][1].equip(Weapons.LONGSWORD.weapon);
        this.items[0][2].equip(Weapons.SWORD.weapon);
       
        this.items[1][0].equip(Weapons.DRAGONTHW.weapon);
        this.items[1][1].equip(Weapons.HALBERD.weapon);
        this.items[1][2].equip(Weapons.RUNETHW.weapon);
        
        this.items[2][0].equip(Weapons.AIRSTAFF.weapon);
        this.items[2][1].equip(Weapons.LAVASTAFF.weapon);
        this.items[2][2].equip(Weapons.PHILOSOPHERS_STONE.weapon);
        
        this.items[3][0].equip(Weapons.LONGBOW.weapon);
        this.items[3][1].equip(Weapons.PRESTINEBOW.weapon);
        this.items[3][2].equip(Weapons.DRAGONBOW.weapon);
        
        this.items[4][0].equip(Weapons.STEELCLAWS.weapon);
        this.items[4][1].equip(Weapons.WHITECLAWS.weapon);
        this.items[4][2].equip(Weapons.DRAGONCLAWS.weapon);
    }

    //Use this method to access slots with a point
    public InventorySlot getSlot(Point point){
        return this.items[point.getX()][point.getY()];
    }
    
    public TakeableItem[][] getItems(){
        TakeableItem[][] items = new TakeableItem[ROW][COL];
        for (int i = 0; i < ROW; i++){
            for (int j = 0; j < COL; j++){
                items[i][j] = this.get(new Point(i,j));
            }
        }
        return items;
    }
    
    public boolean findAndEquip(TakeableItem item){
        for (int i = 0; i < ROW; i++){
            for (int j = 0; j < COL; j++){
                if (items[i][j].has()){
                	continue;
                } else {
                	items[i][j].equip(item);
                	return true;
                }
            }
        }
        return false;
    }
    
    public final TakeableItem get(Point point){
    	TakeableItem temp = this.getSlot(point).get();
        return this.getSlot(point).get();
    }
    
    private int itemCount() {
    	int count = 0;
    	for (int i = 0; i < ROW; i++) {
    		for (int j = 0; j < COL; j++) {
    			if (this.items[i][j].has())
    				count++;
    		}
    	}
    	return count;
    }
    
    public String toString(){
    	StringBuilder builder = new StringBuilder();
    	builder.append("Inventory:" + this.itemCount());
        for (int i = 0; i < ROW; i++){
            for (int j = 0; j < COL; j++){
            	if (this.get(new Point(i, j)) == null) return builder.toString();
                builder.append("\n" + this.get(new Point(i,j)).toString());
            }
        }
        return builder.toString();
    }
    
    protected void primitive(){}
}
