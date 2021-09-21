import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;        //importing the test classes
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShelfNodeTest {     //creating the test class
    private ShelfList sL = new ShelfList();    //instanciating the class
    private Shelf shelf1,shelf2,shelf3;      //variables for test

    @BeforeEach
    void setUp() {
        shelf1 = new Shelf(1);
        shelf2 = new Shelf(2);     //setting up the test objects
        shelf3 = new Shelf(3);
    }

    @AfterEach
    void tearDown() {
        shelf1 = shelf2 = shelf3 = null;
    }        //removing them once finished


    @Test
    void getContents() {
        sL.addShelf(shelf1);
        assertEquals(shelf1,sL.head.getContents());

        sL.addShelf(shelf2);
        assertEquals(shelf2,sL.head.getContents());       //testing the get contents method

        sL.addShelf(shelf3);
        assertEquals(shelf3,sL.head.getContents());
    }
}