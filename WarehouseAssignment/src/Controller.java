/**
 *The controller class handles all input and output of the
 * warehouse managment system
 *
 * @Author : Jason Power (20076537)
 * @Version : FINAL VERSION
 */

/**
 * Importing everything needed for the controller
 * class
 */

import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.util.Scanner;

/**
 * Creating the controller class
 */

public class Controller {
    private Scanner input;
    private FloorList fL = new FloorList();
    private AisleList aL = new AisleList();
    private ShelfList sL = new ShelfList();
    private PalletList pL = new PalletList();

    /**
     * Constructor for the controller class
      */

    public Controller() {
        input = new Scanner(System.in);
    }

    /**
     *Main method run the controller
     * @param args
     */
    public static void main(String args[]) {
        Controller software = new Controller();
        software.runMenu();

    }

    /**
     *Displays the main menu
     */

    private int mainMenu() {
        System.out.println("            WareHouse Management System");
        System.out.println("--------------------------------------------------------");
        System.out.println("1) Add a Floor");
        System.out.println("2) List Floors");
        System.out.println("3) Delete a Floor");
        System.out.println("4) Update a Floor");
        System.out.println("--------------------------------------------------------");
        System.out.println("5) Add a Aisle");
        System.out.println("6) List the Aisles of a Floor");
        System.out.println("7) Delete an Aisle");
        System.out.println("8) Update An Aisle");
        System.out.println("--------------------------------------------------------");
        System.out.println("9) Add a Shelf");
        System.out.println("10) list a Shelf");
        System.out.println("11) Delete a Shelf");
        System.out.println("12) Update a Shelf");
        System.out.println("--------------------------------------------------------");
        System.out.println("13) Add a Pallet");
        System.out.println("14) list a pallets");
        System.out.println("15) Delete a Pallet");
        System.out.println("16) Update a Pallet");
        System.out.println("--------------------------------------------------------");
        System.out.println("17) View All Stock");
        System.out.println("18) Search for Stock");
        System.out.println("19) Reset");
        System.out.println("20) Save to XML");
        System.out.println("21) Load from XML");
        System.out.println("--------------------------------------------------------");


        int choice = input.nextInt();
        return choice;
    }

    /**
     *A switch statement to handle the input for the
     * menu
     */

    private void runMenu() {
        int choice = mainMenu();
        while (choice != 0) {
            switch (choice) {
                case 1:
                    addFloors();
                    break;
                case 2:
                    listFloors();
                    break;
                case 3:
                    deleteFloor();
                    break;
                case 4:
                    updateFloorDetails();
                    break;
                case 5:
                    addAisle();
                    break;
                case 6:
                    listAisles();
                    break;
                case 7:
                    deleteAnAisle();
                    break;
                case 8:
                    updateAnAisle();
                    break;
                case 9:
                    addAShelf();
                    break;
                case 10:
                    listShelfs();
                    break;
                case 11:
                    deleteShelf();
                    break;
                case 12:
                    updateShelf();
                    break;
                case 13:
                    addPallet();
                    break;
                case 14:
                    System.out.println(listPallet());
                    break;
                case 15:
                    deletePallet();
                    break;
                case 16:
                    updateAPallet();
                    break;
                case 17:
                    listAllStock();
                    break;
                case 18:
                    System.out.println(searchForStock());
                    break;
                case 19:
                    reset();
                    break;
                case 20:
                    try{
                        save();
                    }catch (Exception e){
                        System.err.println("Error writing to file: " + e);
                    }
                    break;
                case 21:
                    try{
                        load();
                    }catch (Exception e){
                        System.err.println("Error loading from file: " + e);
                    }
                    break;
            }
            System.out.println("\nPress any key to continue...");
            input.nextLine();
            choice = mainMenu();
        }
        System.out.println("Exiting........bye");
        System.exit(0);
    }

    /**
     * Adds a floor to the list
     */
    public void addFloors() {
        System.out.println("Please enter the number of the floor");
        int floorNumber = input.nextInt();
        System.out.println("Please enter the level of the floor");
        int floorLevel = input.nextInt();
        System.out.println("Please enter the UID of the floor");
        double floorUID = input.nextDouble();
        System.out.println("Please enter the temp of the floor");
        double floorTemp = input.nextDouble();
        System.out.println("Please enter the security level of the Floor i.e high,medium,low");
        input.nextLine();
        String floorSecurityLevel = input.nextLine();
        fL.addFloor(new Floor(floorNumber, floorLevel, floorUID, floorTemp, floorSecurityLevel));
    }

    /**
     * list all the floors in the list
     */

    public void listFloors() {
        System.out.println(fL.listFloors());
    }

    /**
     * Deletes a floor from the list
     */

    public void deleteFloor() {
        System.out.println(fL.listFloors());
        System.out.println("Please enter the Number of the floor you wish to delete");
        int choice = input.nextInt();
        fL.deleteFloor(choice);
    }

    /**
     *Updates a floors details
     */

    public void updateFloorDetails() {
        System.out.println(fL.listFloors());
        if (fL.numberOfFloors() > 0) {
            input.nextLine();
            System.out.println("Please enter the Index of the Floor you want to update");
            int choice = input.nextInt(); //fix indexing

            if ((choice >= 0) && (choice < fL.numberOfFloors())) {
                input.nextLine();
                System.out.println("Please enter the level of the floor");
                int floorLevel = input.nextInt();
                System.out.println("Please enter the UID of the floor");
                double floorUID = input.nextDouble();
                System.out.println("Please enter the temp of the floor");
                double floorTemp = input.nextDouble();
                System.out.println("Please enter the security level of the Floor i.e high,medium,low");
                String floorSecurityLevel = input.nextLine();
                Floor update = fL.findFloor(choice);
                update.setLevel(floorLevel);
                update.setIdentifier(floorUID);
                update.setTemp(floorTemp);
                update.setSecurityLevel(floorSecurityLevel);
            } else {
                System.out.println("There is no Floor for this number");
            }
        }
    }

    /**
     * Adds an an aisle to a floor
     */

    public void addAisle() {
        System.out.println(fL.listFloors());
        if (fL.numberOfFloors() > 0) {
            input.nextLine();
            System.out.println("Please enter the Index of the Floor you want to Add an Aisle to");
            int choice = input.nextInt(); //fix indexing

            if ((choice >= 0) && (choice < fL.numberOfFloors())) {
                input.nextLine();
                System.out.println("Please enter the aisle Identity must be one letter followed by a number e.g. k7");
                String aisleIdentity = input.nextLine();
                System.out.println("Please enter the dimensions of the Aisle i.e width x depth");
                System.out.println("Width : ");
                int width = input.nextInt();

                System.out.println("Depth : ");
                int depth = input.nextInt();

                fL.findFloor(choice).getAisleList().addAisle(new Aisle(aisleIdentity,width,depth));
            } else {
                System.out.println("There is no Floor for this number");
            }
        }

    }

    /**
     * Lists all the aisles of a
     * floor
     */

    public void listAisles() {
        System.out.println(fL.listFloors());
        if (fL.numberOfFloors() > 0) {
            input.nextLine();
            System.out.println("Please enter the Index of the Floor you wish to List the aisles for");
            int choice = input.nextInt(); //fix indexing

            if ((choice >= 0) && (choice < fL.numberOfFloors())) {
                System.out.println(fL.findFloor(choice).getAisleList().listAisles());
            } else {
                System.out.println("There is no Floor for this number");
            }
        }
    }

    /**
     * Deletes an aisle from a floor
     */

    public void deleteAnAisle() {
        System.out.println(fL.listFloors());
        if (fL.numberOfFloors() > 0) {
            input.nextLine();
            System.out.println("Please enter the Index of the Floor you want to Delete an Aisle in ");
            int choice = input.nextInt(); //fix indexing

            if ((choice >= 0) && (choice < fL.numberOfFloors())) {
                System.out.println(fL.findFloor(choice).getAisleList().listAisles());
                System.out.println("Please enter the identifier of the aisle you want to delete");
                input.nextLine();
                String aisleOption = input.nextLine();
                fL.findFloor(choice).getAisleList().deleteAisle(aisleOption);
            }
        } else {
            System.out.println("There is no Floor for this number");
        }
    }

    /**
     * Updates a aisles information
     */

    public void updateAnAisle() {
        System.out.println(fL.listFloors());
        if (fL.numberOfFloors() > 0) {
            input.nextLine();
            System.out.println("Please enter the Index of the Floor you want to Update an Aisle in ");
            int choice = input.nextInt(); //fix indexing

            if ((choice >= 0) && (choice < fL.numberOfFloors())) {
                System.out.println(fL.findFloor(choice).getAisleList().listAisles());
                System.out.println("Please enter the identifier of the aisle you want to update");
                input.nextLine();
                String aisleOption = input.nextLine();
                input.nextLine();

                System.out.println("Please enter a new identifier");
                String iD = input.nextLine();

                System.out.println("Please enter new aisle Dimensions i.e width x depth");
                System.out.println("Width : ");
                int width = input.nextInt();

                System.out.println("Depth : ");
                int depth = input.nextInt();

                Aisle update = fL.findFloor(choice).getAisleList().findAisle(aisleOption);
                update.setAisleIdentity(iD);
                update.setDepth(depth);
                update.setWidth(width);

            } else {
                System.out.println("There is no Floor for this number");
            }
        }
    }

    /**
     * Adds a shelf to aisle on a floor
     *
     */

    public void addAShelf() {
        System.out.println(fL.listFloors());
        if (fL.numberOfFloors() > 0) {
            input.nextLine();
            System.out.println("Please enter the Index of the Floor of the Aisle you want to add a Shelf too");
            int choice = input.nextInt(); //fix indexing

            if ((choice >= 0) && (choice < fL.numberOfFloors())) {
                System.out.println(fL.findFloor(choice).getAisleList().listAisles());
                System.out.println("Please enter the identity of the aisle you want to add a shelf too");
                input.nextLine();
                String aisleOption = input.nextLine().toLowerCase();

                System.out.println("Please enter the shelf number");
                int shelfNumber = input.nextInt();
                fL.findFloor(choice).getAisleList().findAisle(aisleOption).getShelfList().addShelf(new Shelf(shelfNumber));

            } else {
                System.out.println("There is no Floor for this number");

            }

        }

    }

    /**
     * lists all the shelfs in aisle
     */

    public void listShelfs() {
        System.out.println(fL.listFloors());
        if (fL.numberOfFloors() > 0) {
            input.nextLine();
            System.out.println("Please enter the Index of the Floor of the Aisle you want to List a shelf");
            int choice = input.nextInt(); //fix indexing

            if ((choice >= 0) && (choice < fL.numberOfFloors())) {
                System.out.println(fL.findFloor(choice).getAisleList().listAisles());
                System.out.println("Please enter the identity of the aisle you want to list the shelf's of");
                input.nextLine();
                String aisleOption = input.nextLine().toLowerCase();
                System.out.println(fL.findFloor(choice).getAisleList().findAisle(aisleOption).getShelfList().listShelf());

            } else {
                System.out.println("There is no Floor for this number");

            }
        }
    }

    /**
     * Deletes a shelf in an aisle
     */

    public void deleteShelf() {
        System.out.println(fL.listFloors());
        if (fL.numberOfFloors() > 0) {
            input.nextLine();
            System.out.println("Please enter the Index of the Floor you want to Delete a Shelf in ");
            int choice = input.nextInt(); //fix indexing

            if ((choice >= 0) && (choice < fL.numberOfFloors())) {
                System.out.println(fL.findFloor(choice).getAisleList().listAisles());
                System.out.println("Please enter the identifier of the aisle you want to delete a shelf in");
                input.nextLine();
                String aisleOption = input.nextLine();

                System.out.println(fL.findFloor(choice).getAisleList().findAisle(aisleOption).getShelfList().listShelf());
                System.out.println("Please enter the shelf number you wish to delete");
                int shelfChoice = input.nextInt();
                input.nextLine();

                fL.findFloor(choice).getAisleList().findAisle(aisleOption).getShelfList().deleteShelf(shelfChoice);
            } else {
                System.out.println("There is no Floor for this number");

            }
        }
    }

    /**
     * Updates a shelfs information
     */

    public void updateShelf() {
        System.out.println(fL.listFloors());
        if (fL.numberOfFloors() > 0) {
            input.nextLine();
            System.out.println("Please enter the Index of the Floor you want to Update a Shelf in ");
            int choice = input.nextInt(); //fix indexing

            if ((choice >= 0) && (choice < fL.numberOfFloors())) {
                System.out.println(fL.findFloor(choice).getAisleList().listAisles());
                System.out.println("Please enter the identifier of the aisle you want to update a shelf in");
                input.nextLine();
                String aisleOption = input.nextLine();

                System.out.println(fL.findFloor(choice).getAisleList().findAisle(aisleOption).getShelfList().listShelf());
                System.out.println("Please enter the shelf number you wish to update");
                int shelfChoice = input.nextInt();
                input.nextLine();

                System.out.println("Please enter a new shelf number");
                int shelfNum = input.nextInt();
                input.nextLine();

                Shelf update = fL.findFloor(choice).getAisleList().findAisle(aisleOption).getShelfList().findShelf(shelfNum);
                update.setShelfNumber(shelfNum);

            } else {
                System.out.println("There is no Floor for this number");

            }
        }
    }

    /**
     * Adds a pallet to a shelf in an aisle
     */

    public void addPallet() {
        System.out.println(fL.listFloors());
        if (fL.numberOfFloors() > 0) {
            input.nextLine();
            System.out.println("Please enter the Index of the Floor of the Aisle you want to add a Pallet too");
            int choice = input.nextInt(); //fix indexing

            if ((choice >= 0) && (choice < fL.numberOfFloors())) {
                System.out.println(fL.findFloor(choice).getAisleList().listAisles());
                System.out.println("Please enter the identity of the aisle you want to add a Pallet too");
                input.nextLine();
                String aisleOption = input.nextLine().toLowerCase();

                System.out.println(fL.findFloor(choice).getAisleList().findAisle(aisleOption).getShelfList().listShelf());
                System.out.println("Please enter the number of the Shelf you want to add a Pallet to");
                int shelfNumber = input.nextInt();

                    System.out.println("Please enter the name of the good being stored");
                    input.nextLine();
                    String nameOfGood = input.nextLine();

                    System.out.println("Please enter the number of the Pallet");
                    int noOfPallet = input.nextInt();

                    System.out.println("Please enter a Description of the good being stored");
                    input.nextLine();
                    String descOfGood = input.nextLine();


                    System.out.println("Please enter the quantity of the good being stored");
                    double quantity = input.nextDouble();
                    System.out.println("Please enter the maximum and minimum temperature of the goods to be stored");
                    System.out.println("Maximum");
                    double maxTemp = input.nextDouble();
                    System.out.println("Minimum");
                    double minTemp = input.nextDouble();
                    System.out.println("Please enter the coords of the goods you want to be stored i.e width x depth");
                    System.out.println("Width : ");
                    int width = input.nextInt();

                    System.out.println("Depth : ");
                    int depth = input.nextInt();

                    fL.findFloor(choice).getAisleList().findAisle(aisleOption).getShelfList().findShelf(shelfNumber).getPalletList().addPallet(new Pallet(nameOfGood, descOfGood, quantity, maxTemp, minTemp, noOfPallet, width, depth));
                }
            } else {
                System.out.println("There is no Floor for this number");

            }

        }

    /**
     *lists all the pallets on a shelf
     * @return a string on pallets
     */
    public String listPallet() {
        String palletList = "";
        System.out.println(fL.listFloors());
        if (fL.numberOfFloors() > 0) {
            input.nextLine();
            System.out.println("Please enter the Index of the Floor of the Aisle you want to list the Pallets of");
            int choice = input.nextInt(); //fix indexing

            if ((choice >= 0) && (choice < fL.numberOfFloors())) {
                System.out.println(fL.findFloor(choice).getAisleList().listAisles());
                System.out.println("Please enter the identity of the aisle you want to list the Pallets of");
                input.nextLine();
                String aisleOption = input.nextLine().toLowerCase();

                System.out.println(fL.findFloor(choice).getAisleList().findAisle(aisleOption).getShelfList().listShelf());
                System.out.println("Please enter the number of the Shelf you want to to list the Pallets of");
                int shelfNumber = input.nextInt();

                palletList += fL.findFloor(choice).getAisleList().findAisle(aisleOption).getShelfList().findShelf(shelfNumber).getPalletList().listPallet();

            } else {
                System.out.println("There is no Floor for this number");

            }
        }
        return palletList;
    }

    /**
     * Deletes a pallet on a shelf
     */

    public void deletePallet() {
        System.out.println(fL.listFloors());
        if (fL.numberOfFloors() > 0) {
            input.nextLine();
            System.out.println("Please enter the Index of the Floor of the Aisle you want to delete the Pallets of");
            int choice = input.nextInt(); //fix indexing

            if ((choice >= 0) && (choice < fL.numberOfFloors())) {
                System.out.println(fL.findFloor(choice).getAisleList().listAisles());
                System.out.println("Please enter the identity of the aisle you want to delete the Pallets of");
                input.nextLine();
                String aisleOption = input.nextLine().toLowerCase();

                System.out.println(fL.findFloor(choice).getAisleList().findAisle(aisleOption).getShelfList().listShelf());
                System.out.println("Please enter the number of the Shelf you want to to delete the Pallets of");
                int shelfNumber = input.nextInt();

                System.out.println(fL.findFloor(choice).getAisleList().findAisle(aisleOption).getShelfList().findShelf(shelfNumber).getPalletList().listPallet());
                System.out.println("Please enter the number of the Pallet you want to to delete");
                int palletNumber = input.nextInt();

                fL.findFloor(choice).getAisleList().findAisle(aisleOption).getShelfList().findShelf(shelfNumber).getPalletList().deletePallet(palletNumber);
            } else {
                System.out.println("There is no Floor for this number");

            }
        }
    }

    /**
     * Updates a pallets info
     */

    public void updateAPallet() {
        System.out.println(fL.listFloors());
        if (fL.numberOfFloors() > 0) {
            input.nextLine();
            System.out.println("Please enter the Index of the Floor of the Aisle you want to update the Pallets information");
            int choice = input.nextInt(); //fix indexing

            if ((choice >= 0) && (choice < fL.numberOfFloors())) {
                System.out.println(fL.findFloor(choice).getAisleList().listAisles());
                System.out.println("Please enter the identity of the aisle you want to update the Pallets information");
                input.nextLine();
                String aisleOption = input.nextLine().toLowerCase();

                System.out.println(fL.findFloor(choice).getAisleList().findAisle(aisleOption).getShelfList().listShelf());
                System.out.println("Please enter the number of the Shelf you want to update the Pallets information");
                int shelfNumber = input.nextInt();

                System.out.println(fL.findFloor(choice).getAisleList().findAisle(aisleOption).getShelfList().findShelf(shelfNumber).getPalletList().listPallet());
                System.out.println("Please enter the number of the Pallet you want update");
                int palletNumber = input.nextInt();

                System.out.println("Please enter the name of the good being stored");
                input.nextLine();
                String nameOfGood = input.nextLine();

                System.out.println("Please enter the number of the Pallet");
                int noOfPallet = input.nextInt();

                System.out.println("Please enter a Description of the good being stored");
                input.nextLine();
                String descOfGood = input.nextLine();


                System.out.println("Please enter the quantity of the good being stored");
                double quantity = input.nextDouble();
                System.out.println("Please enter the maximum and minimum temperature of the goods to be stored");
                System.out.println("Maximum");
                double maxTemp = input.nextDouble();
                System.out.println("Minimum");
                double minTemp = input.nextDouble();

                System.out.println("Please enter the coords of the goods you want to be stored i.e width x depth");
                System.out.println("Width : ");
                int width = input.nextInt();

                System.out.println("Depth : ");
                int depth = input.nextInt();

                Pallet update = fL.findFloor(choice).getAisleList().findAisle(aisleOption).getShelfList().findShelf(shelfNumber).getPalletList().findPallet(palletNumber);
                update.setNameofGood(nameOfGood);
                update.setPalletNumber(noOfPallet);
                update.setDescOfGoods(descOfGood);
                update.setQuantityOfGoods(quantity);
                update.setMaxTemp(maxTemp);
                update.setMinTemp(minTemp);
                update.setWidth(width);
                update.setDepth(depth);

            } else {
                System.out.println("There is no Floor for this number");

            }
        }
    }

    /**
     * Lists all stock in the system
     */

    public void listAllStock() {
        FloorNode floorNode = null;
        floorNode = fL.head;

        String list = "";

        while (floorNode != null) {
            String aisle = floorNode.getContents().getAisleList().head.getContents().getAisleIdentity();
            int shelfNumber = floorNode.getContents().getAisleList().findAisle(aisle).getShelfList().head.getContents().getShelfNumber();
            list += floorNode.getContents().toString() + floorNode.getContents().getAisleList().listAisles() + floorNode.getContents().getAisleList().findAisle(aisle).getShelfList().listShelf() +
                    floorNode.getContents().getAisleList().findAisle(aisle).getShelfList().findShelf(shelfNumber).getPalletList().listPallet();
                    floorNode = floorNode.next;

        }
        System.out.println(list);
    }

    /**
     * Searches for and returns the sought after product
     * @return the product tostring
     */

    public String searchForStock() {
        System.out.println("Please enter the product you are searching for");
        input.nextLine();
        String product = input.nextLine().toLowerCase();

        FloorNode floorNode = null;
        floorNode = fL.head;

        String foundProduct="";

        String aisle = floorNode.getContents().getAisleList().head.getContents().getAisleIdentity();
        int shelfNumber = floorNode.getContents().getAisleList().findAisle(aisle).getShelfList().head.getContents().getShelfNumber();

        while (floorNode != null) {
            if(product.toLowerCase().contains(floorNode.getContents().getAisleList().findAisle(aisle).getShelfList().findShelf(shelfNumber).getPalletList().head.getContents().getNameofGood())){
                foundProduct += " Floor Number : " + floorNode.getContents().getFloorNumber() +"\n" +
                               " Aisle Identity : " + floorNode.getContents().getAisleList().findAisle(aisle).getAisleIdentity() +"\n" +
                               " Shelf Number : " + floorNode.getContents().getAisleList().findAisle(aisle).getShelfList().findShelf(shelfNumber).getShelfNumber()+"\n"+
                               floorNode.getContents().getAisleList().findAisle(aisle).getShelfList().findShelf(shelfNumber).getPalletList().head.getContents().toString();
            }
            floorNode = floorNode.next;
        }
        if(foundProduct.equals("")){
            return  "No products in this system by that name";
        }
        return foundProduct;
    }

    /**
     * resets the system
     */

    public void reset(){
        System.out.println("Are you sure you want to reset to factory settings Y/N");
        input.nextLine();
        String choice = input.nextLine().toLowerCase();
        resetAction(choice);
    }

    /**
     * resets the system by deleting all the floors
     * @param choice either y or n
     */

    public void resetAction( String choice) {
        FloorNode floorNode = null;
        floorNode = fL.head;

        while (floorNode != null) {
            int floorNumber = floorNode.getContents().getFloorNumber();
            if (choice.toLowerCase().equals("y")) {
                fL.deleteFloor(floorNumber);
            } else {
                runMenu();
            }
            floorNode = floorNode.next;
        }
    }

    /**
     * saves all system information to an xml file
     * @throws Exception
     */

    public void save() throws Exception
    {
        FloorNode floorNode = null;
        floorNode = fL.head;

        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("WarehouseInfo.xml"));
        out.writeObject(floorNode);
        out.writeObject(floorNode.getContents().getAisleList().head);
        out.writeObject(floorNode.getContents().getAisleList().head.getContents().getShelfList().head);
        out.writeObject(floorNode.getContents().getAisleList().head.getContents().getShelfList().head.getContents().getPalletList().head);
        out.close();

    }

    /**
     * Loads all information fromm a xml file at the moment was not able to get it to work
     * @throws Exception
     */

    public void load() throws Exception
    {
        XStream xstream = new XStream(new DomDriver());
        ObjectInputStream is = xstream.createObjectInputStream(new FileReader("WarehouseInfo.xml"));
        is.readObject();
        is.close();
    }

}





