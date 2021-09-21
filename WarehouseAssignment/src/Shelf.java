public class Shelf {  //creating the shelf class
    private int shelfNumber;  //variables for shelf
    private PalletList palletList = new PalletList();  //instanciating the pallet list class

    public Shelf(int shelfNumber) {
        this.shelfNumber = shelfNumber;  //constructor for shelf
    }

    public PalletList getPalletList() {
        return palletList;  //getter for the pallet list
    }

    public void setPalletList(PalletList palletList) {
        this.palletList = palletList;  //setter for the pallet list
    }

    public int getShelfNumber() {
        return shelfNumber;  //getter for the shelf number
    }

    public void setShelfNumber(int shelfNumber) {  //setter for the shelf number
        this.shelfNumber = shelfNumber;
    }


    @Override
    public String toString() {
        return "--------------------------------------------------------"+"\n" +  //to string for the shelf
                " Shelf Number : " + shelfNumber + "\n"+
                "--------------------------------------------------------"+"\n";
    }
}
