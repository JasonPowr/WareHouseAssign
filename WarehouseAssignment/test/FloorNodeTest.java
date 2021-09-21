import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;  //importing the test classes
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FloorNodeTest {  //creating the test class
    private FloorList fL = new FloorList();     //instanciating the class
    public Floor floor1,floor2,floor3;  //variables for test

    @BeforeEach
    void setUp() {
        floor1 = new Floor(1,1,1,3,"High");
        floor2 = new Floor(2,2,2,5,"Medium");       //setting up the test objects
        floor3 = new Floor(3,3,3,1,"Low");
    }

    @AfterEach
    void tearDown() {
        floor1 = floor2 = floor3 = null;
    } //removing them once finished

    @Test
    void getContents() {
        fL.addFloor(floor1);
        assertEquals(floor1, fL.head.getContents());

        fL.addFloor(floor2);
        assertEquals(floor2, fL.head.getContents());  //testing the get contents method

        fL.addFloor(floor3);
        assertEquals(floor3, fL.head.getContents());
    }

}