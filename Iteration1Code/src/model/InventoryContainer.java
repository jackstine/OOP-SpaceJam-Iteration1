package model;

public class InventoryContainer {
    protected final int COL = 6;
    protected final int ROW = 5;
    protected InventorySlot[][] items;    

    InventoryContainer(){
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
    protected Slotable<Item> getSlot(Point point){
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
    
    public final Item get(Point point){                 //Template Method
        return this.getSlot(point).get();
    }
}
