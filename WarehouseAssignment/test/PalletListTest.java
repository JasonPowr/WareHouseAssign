import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;        //importing the test classes
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalletListTest {        //creating the test class
    private PalletList pL = new PalletList();     //instanciating the class
    private Pallet pallet1,pallet2,pallet3; //variables for test

    @BeforeEach
    void setUp() {
        pallet1 = new Pallet("Monster Energy", "energy drink", 82, 2, 0, 1, 3, 2);
        pallet2 = new Pallet("Nescafe", "Coffee", 60, 2, 0, 2, 7, 8);     //setting up the test objects
        pallet3 = new Pallet("Bic Pens", "pens", 40, 8, 0, 3, 4, 2);
    }

    @AfterEach
    void tearDown() {
        pallet1 = pallet2 = pallet3 = null;        //removing them once finished
    }

    @Test
    void addPallet() {
        pL.addPallet(pallet1);
        assertEquals(1,pL.head.getContents().getPalletNumber());

        pL.addPallet(pallet2);
        assertEquals(2,pL.head.getContents().getPalletNumber());     //testing the add pallet method

        pL.addPallet(pallet3);
        assertEquals(3,pL.head.getContents().getPalletNumber());
    }

    @Test
    void listPallet() {
        assertEquals("No floors in the system",pL.listPallet());

        pL.addPallet(pallet1);
        pL.addPallet(pallet2);
        pL.addPallet(pallet3);

        assertEquals("--------------------------------------------------------\n" +
                " Pallet Number : 3\n" +
                " Name : Bic Pens\n" +
                " Description : pens\n" +
                " Quantity : 40.0\n" +
                " Maximum Storage Temperature : 8.0\n" +
                " Minimum Storage Temperature : 0.0\n" +
                " Coordinates of Goods : 4 x 2\n" +
                "--------------------------------------------------------\n" +                  //testing the list pallet method
                "--------------------------------------------------------\n" +
                " Pallet Number : 2\n" +
                " Name : Nescafe\n" +
                " Description : Coffee\n" +
                " Quantity : 60.0\n" +
                " Maximum Storage Temperature : 2.0\n" +
                " Minimum Storage Temperature : 0.0\n" +
                " Coordinates of Goods : 7 x 8\n" +
                "--------------------------------------------------------\n" +
                "--------------------------------------------------------\n" +
                " Pallet Number : 1\n" +
                " Name : Monster Energy\n" +
                " Description : energy drink\n" +
                " Quantity : 82.0\n" +
                " Maximum Storage Temperature : 2.0\n" +
                " Minimum Storage Temperature : 0.0\n" +
                " Coordinates of Goods : 3 x 2\n" +
                "--------------------------------------------------------\n", pL.listPallet());
    }

    @Test
    void findPallet() {
        pL.addPallet(pallet1);
        assertEquals(pallet1, pL.findPallet(1));

        pL.addPallet(pallet2);
        assertEquals(pallet2, pL.findPallet(2));           //testing the find pallet method

        pL.addPallet(pallet3);
        assertEquals(pallet3, pL.findPallet(3));
    }

    @Test
    void numberOfPallets() {
        pL.addPallet(pallet1);
        pL.addPallet(pallet2);                         //testing the number of the pallets
        pL.addPallet(pallet3);

        assertEquals(3,pL.numberOfPallets());

    }

    @Test
    void deletePallet() {
        pL.addPallet(pallet1);
        pL.deletePallet(1);           //testing the find pallets method
        assertEquals(0,pL.numberOfPallets());
    }
}