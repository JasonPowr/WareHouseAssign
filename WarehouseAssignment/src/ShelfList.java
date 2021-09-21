public class ShelfList { //creating the shelf list class
    public ShelfNode head;  //variable for shelfnode

    public void addShelf(Shelf s) {
        ShelfNode sn = new ShelfNode();
        sn.setContents(s);    //adds a shelf to the list of shelfs
        sn.next = head;
        head = sn;
    }

    public  String listShelf() {
        if (numberOfShelfs() == 0) {
            return "No Shelfs in the system";
        }
        ShelfNode node = head;
        String ShelfList = "";                                  //builds and lists the shelfs

        while (node != null) {
            ShelfList += node.getContents().toString();
            node = node.next;
        }
        return ShelfList;
    }

    public Shelf findShelf(int shelfNumber) {
        if (numberOfShelfs() == 0) {
            System.out.println("No shelfs in System by this number");
        }
        ShelfNode tempShelf = head;                             //finds a shelf using its shelf number
        for (int i = 0; i < listShelf().length() && tempShelf != null; i++) {
            if (shelfNumber == head.getContents().getShelfNumber()) {
                return head.getContents();
            }
        }
        return head.getContents();
    }

    public int numberOfShelfs() {
        ShelfNode node = head;
        int numberOfShelfs = 0;

        while (node != null) {              //counts the amount of shelfs
            numberOfShelfs++;
            node = node.next;
        }
        return numberOfShelfs;
    }

    public void deleteShelf(int shelfNumber) {
        if (numberOfShelfs() == 0) {
            System.out.println("No shelfs in System by this number");
        }
        ShelfNode tempShelf = head;
        int i = 0;
        while (i < numberOfShelfs()  && tempShelf != null) {
            if (shelfNumber == head.getContents().getShelfNumber()) {         //deletes a shelf using its number
                head = head.next;
                tempShelf = tempShelf.next;
            }
            i++;
        }
        if (tempShelf != null && tempShelf.next != null) {
            tempShelf.next = tempShelf.next.next;
        }
    }

    }


