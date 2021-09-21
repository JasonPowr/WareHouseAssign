import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;        //importing the test classes
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalletNodeTest {     //creating the test class
    private PalletList pL = new PalletList();     //instanciating the class
    private Pallet pallet1,pallet2,pallet3;//variables for test

    @BeforeEach
    void setUp() {
        pallet1 = new Pallet("Monster Energy", "energy drink", 82, 2, 0, 1, 3, 2);
        pallet2 = new Pallet("Nescafe", "Coffee", 60, 2, 0, 2, 7, 8);     //setting up the test objects
        pallet3 = new Pallet("Bic Pens", "pens", 40, 8, 0, 3, 4, 2);
    }

    @AfterEach
    void tearDown(){
        pallet1 = pallet2 = pallet3 = null;        //removing them once finished
    }


    @Test
    void getContents() {
        pL.addPallet(pallet1);
        assertEquals(pallet1, pL.head.getContents());

        pL.addPallet(pallet2);
        assertEquals(pallet2, pL.head.getContents());       //testing the get contents method

        pL.addPallet(pallet3);
        assertEquals(pallet3, pL.head.getContents());
    }
}