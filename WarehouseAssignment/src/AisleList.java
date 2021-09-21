public class AisleList {  //creating the aisle list class
    AisleNode head;  //creating the head of the aisleNode

    public void addAisle(Aisle a) {  //method to add an aisle to the list
        AisleNode aN = new AisleNode(); //instanciating the aislenode class
        aN.setContents(a);  //setting the contents using the setter in the aisle node class
        aN.next = head;  //Making the next Node in the List the new head
        head = aN; //setting the head to be the aisle node
    }


    public String listAisles() {  //method for listing the aisle's
        if (numberOfAisles() == 0) {
            return "No Aisles in System";    // if theres nothing in te list return that
        }

        AisleNode node = head;  //creating the variable node and letting it equal to the head of the list
        String aisleList = "";   //creating an empty list called aisleList

        while (node != null) {   //while theres something in the list
            aisleList += node.getContents().toString();  // adds the contents to the list
            node = node.next; //moves the loop on to the next node
        }
        return aisleList; //returns the list
    }


    public int numberOfAisles() {  //method to count the number of aisles
        AisleNode node = head;   //creating the variable node and letting it equal to the head of the list
        int numberOfAisles = 0;  //creating a counter of type int and setting it = 0

        while (node != null) {  //while theres something in the list
            numberOfAisles++; //for every object in the list add 1 to the counter
            node = node.next;  //moves the loop on to the next node
        }
        return numberOfAisles;   //returns the number
    }

    public Aisle findAisle(String aisleIdentity) {  //method to find the aisle object if it matches the id
        if (numberOfAisles() == 0) {
            System.out.println("No Aisles in System");   // if theres nothing in te list return that
        }
        AisleNode tempAisle = head;         //creating the variable tempnode and letting it equal to the head of the list
        for (int i = 0; i < listAisles().length() && tempAisle != null; i++) {
            if (aisleIdentity.toLowerCase().contains(head.getContents().aisleIdentity.toLowerCase())) {             //cycles through the list and checks for the aisle identity if it matches it returns it
                return head.getContents();
            }
        }
        return head.getContents();  //returns it
    }

    public void deleteAisle(String aisleIdentifier) {
        if (numberOfAisles() == 0) {            // // if theres nothing in te list return that
            System.out.println("No Aisles in System");
        }
        AisleNode tempAisle = head;         //creating the variable tempnode and letting it equal to the head of the list
        int i = 0;
        while (i < numberOfAisles() && tempAisle != null) {
            if (aisleIdentifier.equals(head.getContents().getAisleIdentity())) {
                head = head.next;               ////cycles through the list and checks for the aisle identity if it matches it deletes it
                tempAisle = tempAisle.next;
            }
            i++;
        }
        if (tempAisle != null && tempAisle.next != null) {          // if tempaisle and the next tempaisle is null then it keeps it moving
            tempAisle.next = tempAisle.next.next;
        }
    }

}


