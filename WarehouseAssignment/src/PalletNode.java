public class PalletNode { //creating the class palletnode
    public PalletNode next = null;
    private Pallet contents;  //variables for palletnode

    public Pallet getContents() {  //getter for contents
        return contents;
    }

    public void setContents(Pallet contents) {
        this.contents = contents;  //setter for contents
    }
}

