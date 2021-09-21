public class Aisle {  //creating a aisle class
    public String aisleIdentity;
    public int width, depth;    //variables for aisle
    public ShelfList shelfList = new ShelfList();  //instanciating the shelf list

    public Aisle(String aisleIdentity, int width, int depth) {
        this.aisleIdentity = aisleIdentity;
        this.width = width;   //constructor for aisle
        this.depth = depth;
    }

    public int getWidth() {
        return width;      //getter for width
    }

    public void setWidth(int width) {
        this.width = width;  //setter for width
    }

    public int getDepth() {  //getter for depth
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;   //setter for depth
    }

    public ShelfList getShelfList() {
        return shelfList;  //getter for the shelf list
    }

    public void setShelfList(ShelfList shelfList) {
        this.shelfList = shelfList; //setter for the shelf list
    }

    public String getAisleIdentity() {  //getter for the aisle identity
        return aisleIdentity;
    }

    public void setAisleIdentity(String aisleIdentity) {
        this.aisleIdentity = aisleIdentity;  //setter for aisle identity
    }

    @Override
    public String toString() {
        return  "--------------------------------------------------------"+"\n"+
                "Aisle Identity : " + aisleIdentity +"\n"+
                "Aisle Dimensions : " + width + " x " + depth +"\n"+         //too string for Aisle Class
                "--------------------------------------------------------"+"\n";
    }
}
