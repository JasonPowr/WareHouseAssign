public class FloorList {  //creating the floorlist class
    FloorNode head;

    public void addFloor(Floor f) {
        FloorNode fn = new FloorNode();
        fn.setContents(f);   //adds a floor to the list
        fn.next = head;
        head = fn;
    }

    public String listFloors() {
        if (numberOfFloors() == 0) {
            return "No floors in the system";
        }
        FloorNode node = head;
        String floorList = "";
                                     //builds a list of floors
        while (node != null) {
            floorList += node.getContents().toString();
            node = node.next;
        }
        return floorList;
    }

    public int numberOfFloors() {
        FloorNode node = head;
        int numberOfFloors = 0;

        while (node != null) {
            numberOfFloors++;     //gets the number of floors
            node = node.next;
        }
        return numberOfFloors;
    }

    public Floor findFloor(int floorNumber) {
        if (numberOfFloors() == 0) {
            System.out.println("No floors in the system");
        }                                  //finds the floor using the floor number
        FloorNode tempFloor = head;
        while (tempFloor != null) {
            if (floorNumber == tempFloor.getContents().getFloorNumber()) {
                return head.getContents();
            }
            tempFloor = tempFloor.next;
        }
        return head.getContents();
    }

    public void deleteFloor(int floorNumber) {
        if (numberOfFloors() == 0) {
            System.out.println("No floors in the system");
        }
        FloorNode tempFloor = head;   //deletes the floor using the floor number
        int i = 0;
        while (i < numberOfFloors() && tempFloor != null) {
            if (floorNumber == head.getContents().getFloorNumber()) {
                head = head.next;
                tempFloor = tempFloor.next;
            }
            i++;
        }
        if (tempFloor != null && tempFloor.next != null) {
            tempFloor.next = tempFloor.next.next;
        }
    }
}



