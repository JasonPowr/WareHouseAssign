import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;    //importing the test classes
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShelfListTest {       //creating the test class
    private ShelfList sL = new ShelfList();     //instanciating the class
    private Shelf shelf1,shelf2,shelf3;//variables for test

    @BeforeEach
    void setUp() {
        shelf1 = new Shelf(1);
        shelf2 = new Shelf(2);     //setting up the test objects
        shelf3 = new Shelf(3);
    }

    @AfterEach
    void tearDown() {
        shelf1 = shelf2 = shelf3 = null;        //removing them once finished
    }

    @Test
    void addShelf() {
        sL.addShelf(shelf1);
        assertEquals(1, sL.head.getContents().getShelfNumber());

        sL.addShelf(shelf2);
        assertEquals(2, sL.head.getContents().getShelfNumber());    //testing the add shelf method

        sL.addShelf(shelf3);
        assertEquals(3, sL.head.getContents().getShelfNumber());
    }

    @Test
    void listShelf() {
        assertEquals("No Shelfs in the system", sL.listShelf());

        sL.addShelf(shelf1);
        sL.addShelf(shelf2);
        sL.addShelf(shelf3);

        assertEquals("--------------------------------------------------------\n" +                 //testing the list shelf method
                " Shelf Number : 3\n" +
                "--------------------------------------------------------\n" +
                "--------------------------------------------------------\n" +
                " Shelf Number : 2\n" +
                "--------------------------------------------------------\n" +
                "--------------------------------------------------------\n" +
                " Shelf Number : 1\n" +
                "--------------------------------------------------------\n", sL.listShelf());
    }

    @Test
    void findShelf() {
        sL.addShelf(shelf1);
        assertEquals(shelf1, sL.findShelf(1));

        sL.addShelf(shelf2);
        assertEquals(shelf2, sL.findShelf(3));           //testing the find shelf method

        sL.addShelf(shelf3);
        assertEquals(shelf3, sL.findShelf(3));
    }

    @Test
    void numberOfShelfs() {
        sL.addShelf(shelf1);
        sL.addShelf(shelf2);                        //testing the number of the shelfs
        sL.addShelf(shelf3);
        assertEquals(3,sL.numberOfShelfs());
    }

    @Test
    void deleteShelf() {
        sL.addShelf(shelf1);
        sL.deleteShelf(1);        //testing the find shelfs method
        assertEquals(0,sL.numberOfShelfs());
    }
}