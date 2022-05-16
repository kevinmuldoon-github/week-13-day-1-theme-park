package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class RollercoasterTest {

    RollerCoaster rollerCoaster;
    private Visitor visitor1, visitor2;

    @Before
    public void setUp() {
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
        visitor1 = new Visitor(19, 220, 25);
        visitor2 = new Visitor(11, 120, 10);
    }

    @Test
    public void hasName() {
        assertEquals("Blue Ridge", rollerCoaster.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(10, rollerCoaster.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, rollerCoaster.getVisitCount());
    }

    @Test
    public void canUseRollercoaster(){
        assertEquals(true, rollerCoaster.isAllowedTo(visitor1));
        assertEquals(false, rollerCoaster.isAllowedTo(visitor2));
    }

    @Test
    public void checkDefaultPrice(){
        assertEquals(8.40, rollerCoaster.defaultPrice(), 0.0);
    }

    @Test
    public void checkPriceForTallPeople(){
        assertEquals(16.80, rollerCoaster.priceFor(visitor1), 0.0);
        assertEquals(8.4, rollerCoaster.priceFor(visitor2), 0.0);
    }


}
