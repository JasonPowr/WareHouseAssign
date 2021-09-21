public class ShelfNode {  //creates the shelf node class
    public ShelfNode next = null;  //variables for shelf node class
    private Shelf contents;

    public Shelf getContents() {
        return contents;   //getter for contents
    }

    public void setContents(Shelf contents) {
        this.contents = contents;  //setter for the contents
    }
}
