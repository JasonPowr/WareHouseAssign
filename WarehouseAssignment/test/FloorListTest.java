import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;        //importing the test classes
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FloorListTest {   //creating the test class
    private FloorList fL = new FloorList();     //instanciating the class
    public Floor floor1,floor2,floor3;      //variables for test

    @BeforeEach
    void setUp() {
        floor1 = new Floor(1,1,1,3,"High");
        floor2 = new Floor(2,2,2,5,"Medium");      //setting up the test objects
        floor3 = new Floor(3,3,3,1,"Low");
    }

    @AfterEach
    void tearDown() {
        floor1 = floor2 = floor3 = null;        //removing them once finished
    }

    @Test
    void addFloor() {
         fL.addFloor(floor1);
         assertEquals(1, fL.head.getContents().getFloorNumber());

         fL.addFloor(floor2);
         assertEquals(2, fL.head.getContents().getFloorNumber());      //testing the add floor method

         fL.addFloor(floor3);
         assertEquals(3, fL.head.getContents().getFloorNumber());
    }

    @Test
    void listFloors() {
        assertEquals("No floors in the system",fL.listFloors());
        fL.addFloor(floor1);
        assertEquals(1, fL.head.getContents().getFloorNumber());

        fL.addFloor(floor2);                            //testing the list floors method
        assertEquals(2, fL.head.getContents().getFloorNumber());

        fL.addFloor(floor3);
        assertEquals(3, fL.head.getContents().getFloorNumber());

        assertEquals("--------------------------------------------------------\n" +
                "Floor Number : 3\n" +
                "Level : 3\n" +
                "Unique Identifier : 3.0\n" +
                "Floor Storage Temperature : 1.0\n" +
                "Security Level : Low\n" +
                "--------------------------------------------------------\n" +
                "--------------------------------------------------------\n" +
                "Floor Number : 2\n" +
                "Level : 2\n" +
                "Unique Identifier : 2.0\n" +
                "Floor Storage Temperature : 5.0\n" +
                "Security Level : Medium\n" +
                "--------------------------------------------------------\n" +
                "--------------------------------------------------------\n" +
                "Floor Number : 1\n" +
                "Level : 1\n" +
                "Unique Identifier : 1.0\n" +
                "Floor Storage Temperature : 3.0\n" +
                "Security Level : High\n" +
                "--------------------------------------------------------\n", fL.listFloors());
    }

    @Test
    void numberOfFloors() {
        fL.addFloor(floor1);
        assertEquals(1, fL.head.getContents().getFloorNumber());

        fL.addFloor(floor2);
        assertEquals(2, fL.head.getContents().getFloorNumber());
                                                                            //testing the number of the floors
        fL.addFloor(floor3);
        assertEquals(3, fL.head.getContents().getFloorNumber());

        assertEquals(3,fL.numberOfFloors());
    }

    @Test
    void findFloor() {
        fL.addFloor(floor1);
        assertEquals(1, fL.head.getContents().getFloorNumber());
        assertEquals(floor1, fL.findFloor(1));

        fL.addFloor(floor2);
        assertEquals(2, fL.head.getContents().getFloorNumber());            //testing the find floor method
        assertEquals(floor2, fL.findFloor(2));

        fL.addFloor(floor3);
        assertEquals(3, fL.head.getContents().getFloorNumber());
        assertEquals(floor3, fL.findFloor(3));
    }

    @Test
    void deleteFloor() {
        fL.addFloor(floor1);
        assertEquals(1, fL.head.getContents().getFloorNumber());
        fL.deleteFloor(1);   //testing the delete floor method
        assertEquals(0, fL.numberOfFloors());

    }
}