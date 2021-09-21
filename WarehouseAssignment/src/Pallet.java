public class Pallet {   //creating the pallet class
    private String nameofGood,descOfGoods;
    private double quantityOfGoods, maxTemp, minTemp;  //variables for pallet class
    private int palletNumber, width ,depth;

    public Pallet(String nameofGood, String descOfGoods, double quantityOfGoods, double maxTemp, double minTemp, int palletNumber, int width, int depth) {
        this.nameofGood = nameofGood;
        this.descOfGoods = descOfGoods;
        this.quantityOfGoods = quantityOfGoods;
        this.maxTemp = maxTemp;  //constructor for pallet class
        this.minTemp = minTemp;
        this.palletNumber = palletNumber;
        this.width = width;
        this.depth = depth;
    }

    public int getWidth() {
        return width;       //getter for pallet width
    }

    public void setWidth(int width) {
        this.width = width;  //setter for width
    }

    public int getDepth() {  //getter for depth
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;     //setter for depth
    }

    public String getNameofGood() {
        return nameofGood;  //getter for name
    }

    public void setNameofGood(String nameofGood) {
        this.nameofGood = nameofGood;
    }       //setter for the name

    public String getDescOfGoods() {
        return descOfGoods;  //getter for the desc
    }

    public void setDescOfGoods(String descOfGoods) {
        this.descOfGoods = descOfGoods; //setter for the desc
    }

    public double getQuantityOfGoods() {  //getter for the quantity
        return quantityOfGoods;
    }

    public void setQuantityOfGoods(double quantityOfGoods) { //setter for the quantity
        this.quantityOfGoods = quantityOfGoods;
    }

    public double getMaxTemp() {
        return maxTemp;  //getter for the max temp
    }

    public void setMaxTemp(double maxTemp) {
        this.maxTemp = maxTemp;  //setter for max temp
    }

    public double getMinTemp() {
        return minTemp;  //getter for min temp
    }

    public void setMinTemp(double minTemp) {  //setter for min temp
        this.minTemp = minTemp;
    }

    public int getPalletNumber() {
        return palletNumber;  //getter for the pallet number
    }

    public void setPalletNumber(int palletNumber) {
        this.palletNumber = palletNumber;  //setter for the pallet number
    }

    @Override
    public String toString() {
        return  "--------------------------------------------------------"+"\n"+
                " Pallet Number : " + palletNumber +"\n" +
                " Name : " + nameofGood +"\n" +
                " Description : " + descOfGoods +"\n" +
                " Quantity : " + quantityOfGoods +"\n" +            //tostring for the pallet object
                " Maximum Storage Temperature : " + maxTemp +"\n" +
                " Minimum Storage Temperature : " + minTemp +"\n" +
                " Coordinates of Goods : " + width + " x " + depth +"\n" +
                "--------------------------------------------------------"+"\n";
    }
}
