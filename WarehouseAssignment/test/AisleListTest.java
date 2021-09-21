import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;  //importing the testing classes
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AisleListTest { //creating the aislelist test
    private AisleList aL = new AisleList();    //instanciateing the aislist class
    public Aisle aisle1,aisle2,aisle3;  //variables for test

    @BeforeEach
    void setUp() {
        aisle1 = new Aisle("A1", 2, 4);
        aisle2 = new Aisle("B1", 6, 3);  //setting up the test objects
        aisle3 = new Aisle("C1", 2, 6);
    }

    @AfterEach
    void tearDown() {
        aisle1 = aisle2 = aisle3 =null;  //removing them once finished
    }

    @Test
    void addAisle() {
        aL.addAisle(aisle1);
        assertEquals("A1",aL.head.getContents().getAisleIdentity());

        aL.addAisle(aisle2);
        assertEquals("B1",aL.head.getContents().getAisleIdentity());   //testing the add aisle method

        aL.addAisle(aisle3);
        assertEquals("C1",aL.head.getContents().getAisleIdentity());
    }

    @Test
    void listAisles() {
        assertEquals("No Aisles in System",aL.listAisles());

        aL.addAisle(aisle1);
        aL.addAisle(aisle2);
        aL.addAisle(aisle3);
        assertEquals("--------------------------------------------------------\n" +       //testing the list aisle method
                "Aisle Identity : C1\n" +
                "Aisle Dimensions : 2 x 6\n" +
                "--------------------------------------------------------\n" +
                "--------------------------------------------------------\n" +
                "Aisle Identity : B1\n" +
                "Aisle Dimensions : 6 x 3\n" +
                "--------------------------------------------------------\n" +
                "--------------------------------------------------------\n" +
                "Aisle Identity : A1\n" +
                "Aisle Dimensions : 2 x 4\n" +
                "--------------------------------------------------------\n",aL.listAisles());

    }

    @Test
    void numberOfAisles() {
        aL.addAisle(aisle1);
        aL.addAisle(aisle2);
        aL.addAisle(aisle3);            //testing the number of aisle method
        assertEquals(3,aL.numberOfAisles());
    }

    @Test
    void findAisle() {
        aL.addAisle(aisle1);
        assertEquals(aisle1,aL.findAisle("A1"));

        aL.addAisle(aisle2);
        assertEquals(aisle2,aL.findAisle("B1"));        //testing the find aisle method

        aL.addAisle(aisle3);
        assertEquals(aisle3,aL.findAisle("C1"));
    }

    @Test
    void deleteAisle() {
        aL.addAisle(aisle1);
        aL.deleteAisle("A1");
        assertEquals(0,aL.numberOfAisles());        //testing the delete method
    }
}