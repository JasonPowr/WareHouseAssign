import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {
    private Scanner input;
    private FloorList fL = new FloorList();
    private AisleList aL = new AisleList();
    private ShelfList sL = new ShelfList();
    private PalletList pL = new PalletList();
    private Controller c = new Controller();

    public Floor floor1,floor2,floor3;
    public Aisle aisle1, aisle2, aisle3;
    public Shelf shelf1, shelf2, shelf3;
    public Pallet pallet1, pallet2, pallet3;

    @BeforeEach
    void setUp(){
        floor1 = new Floor(1,1,1,4,"High");
        floor2 = new Floor(2,2,2,-2,"Medium");
        floor3 = new Floor(3,3,3,5,"Low");

        aisle1 = new Aisle("A1",4,8);
        aisle2 = new Aisle("B1",1,2);
        aisle3 = new Aisle("C!",3,7);

        shelf1 = new Shelf(1);
        shelf2 = new Shelf(1);
        shelf3 = new Shelf(1);

        pallet1 = new Pallet("Monster Energy","Energy Drinks",48,2,-5,1,1,2);
        pallet2 = new Pallet("Nescafe","Coffe",23,10,0,1,3,4);
        pallet3 = new Pallet("Bic Pens","Pens",32,15,0,1,5,1);
    }

    @AfterEach
    void tearDown() {
        floor1 = floor2 = floor3 = null;
        aisle1 = aisle2 = aisle3 = null;
        shelf1 = shelf2 = shelf3 = null;
        pallet1 = pallet2 = pallet3 = null;
    }


    @Test
    void addFloors() {
        fL.addFloor(floor1);
        assertEquals(floor1, fL.findFloor(1));

        fL.addFloor(floor2);
        assertEquals(floor2,fL.findFloor(2));

        fL.addFloor(floor3);
        assertEquals(floor3, fL.findFloor(3));
    }

    @Test
    void addAisle() {
        aL.addAisle(aisle1);
        assertEquals(aisle1, aL.findAisle("A1"));

        aL.addAisle(aisle2);
        assertEquals(aisle2, aL.findAisle("B1"));

        aL.addAisle(aisle3);
        assertEquals(aisle3, aL.findAisle("C1"));

    }

    @Test
    void addAShelf() {
        sL.addShelf(shelf1);
        assertEquals(shelf1, sL.findShelf(1));

        sL.addShelf(shelf2);
        assertEquals(shelf2, sL.findShelf(1));

        sL.addShelf(shelf3);
        assertEquals(shelf3, sL.findShelf(1));
    }

    @Test
    void addPallet() {
        pL.addPallet(pallet1);
        assertEquals(pallet1, pL.findPallet(1));

        pL.addPallet(pallet2);
        assertEquals(pallet2, pL.findPallet(1));

        pL.addPallet(pallet3);
        assertEquals(pallet3, pL.findPallet(1));
    }

    @Test
    void listAllStock() {
    }

    @Test
    void searchForStock() {

    }

    @Test
    void reset() {
    }

    @Test
    void save() {

    }

    @Test
    void load() {
    }
}