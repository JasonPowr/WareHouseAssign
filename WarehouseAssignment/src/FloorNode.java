public class FloorNode { // creates the floornode class
    public FloorNode next = null;
    private Floor contents;  //variables for class

    public Floor getContents() {  //getter for contents
        return contents;
    }

    public void setContents(Floor contents) {  //setter for contents
        this.contents = contents;
    }

}