public class AisleNode {    //creating the aisle node
    public AisleNode next = null;
    private Aisle contents;  //creating the variable contents i.e the aisle info

    public Aisle getContents() {
        return contents;   //getter for the contents
    }

    public void setContents(Aisle contents) {
        this.contents = contents;  //setter for the contents
    }
}
