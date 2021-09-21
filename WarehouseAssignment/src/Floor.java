public class Floor {  //creating the floot class
    private int floorNumber,level;
    private double identifier,temp;
    private String securityLevel;    //variables for floor
    private AisleList aisleList = new AisleList();  //instancating the aislelist

    public Floor(int floorNumber, int level, double identifier,double temp,String securityLevel) {
        this.floorNumber = floorNumber;
        this.level = level;
        this.identifier = identifier;           //constructor for floor object
        this.temp = temp;
        this.securityLevel = securityLevel;
    }

    public AisleList getAisleList() {
        return aisleList;           //getter for the aisle list
    }

    public void setAisleList(AisleList aisleList) {
        this.aisleList = aisleList;  //setter for the aisle list
    }

    public int getFloorNumber() {
        return floorNumber;  //getter for the floor number
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;  //setter for the floor number
    }

    public int getLevel() {
        return level;   //getter for the level
    }

    public void setLevel(int level) {
        this.level = level;  //setter for the level
    }

    public double getIdentifier() {
        return identifier;  //getter for the id
    }

    public void setIdentifier(double identifier) {
        this.identifier = identifier;  //setter for the id
    }

    public double getTemp() {
        return temp;  //getter for the temp
    }

    public void setTemp(double temp) {
        this.temp = temp; //setter for the temp
    }

    public String getSecurityLevel() {
        return securityLevel;  //getter for the security level
    }

    public void setSecurityLevel(String securityLevel) {
        this.securityLevel = securityLevel;  //setter for the security level
    }

    @Override
    public String toString() {
        return  "--------------------------------------------------------"+"\n"+
                "Floor Number : " + floorNumber + "\n"+
                "Level : " + level + "\n"+
                "Unique Identifier : " + identifier + "\n"+
                "Floor Storage Temperature : " + temp + "\n"+  //to string for floor
                "Security Level : " + securityLevel + "\n"+
                "--------------------------------------------------------"+"\n";
    }
}
