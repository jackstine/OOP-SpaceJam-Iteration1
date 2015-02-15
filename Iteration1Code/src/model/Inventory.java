package model;

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
    }

    //Use this method to access slots with a point
    public InventorySlot getSlot(Point point){
        return this.items[point.getX()][point.getY()];
    }
    
    public Item[][] getItems(){
        Item[][] items = new Item[ROW][COL];
        for (int i = 0; i < ROW; i++){
            for (int j = 0; j < COL; j++){
                items[i][j] = this.get(new Point(i,j));
            }
        }
        return items;
    }
    
    public boolean findAndEquip(Item item){
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
    
    public final Item get(Point point){
        return this.getSlot(point).get();
    }
    
    private int itemCount() {
    	int count = 0;
    	for (int i = 0; i < ROW; i++) {
    		for (int j = 0; j < COL; j++) {
    			if (!this.items[i][j].has()) return count;
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
