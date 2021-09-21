import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;        //importing the testing classes
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AisleNodeTest {       //creating the aisleNode test
    private AisleList aL = new AisleList();  //instanciateing the aislelist class
    public Aisle aisle1,aisle2,aisle3;  //variables for test

    @BeforeEach
    void setUp() {
        aisle1 = new Aisle("A1", 2, 4);
        aisle2 = new Aisle("B1", 6, 3);     //setting up the test objects
        aisle3 = new Aisle("C1", 2, 6);
    }

    @AfterEach
    void tearDown() {
        aisle1 = aisle2 = aisle3 =null;     //removing them once finished
    }

    @Test
    void getContents() {
        aL.addAisle(aisle1);
        assertEquals(aisle1,aL.head.getContents());

        aL.addAisle(aisle2);
        assertEquals(aisle2,aL.head.getContents());     //testing the get contents method

        aL.addAisle(aisle3);
        assertEquals(aisle3,aL.head.getContents());
    }
}