package people;

import attractions.Attraction;
import attractions.Dodgems;
import attractions.Park;
import attractions.RollerCoaster;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class VisitorTest {

    Visitor visitor;
    private Attraction dodgems, park, rollerCoaster;


    @Before
    public void before(){
        visitor = new Visitor(14, 1.2, 40.0);
        dodgems = new Dodgems("Bumper Cars", 5);
        park = new Park("Leafy Meadows", 9);
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
    }

    @Test
    public void hasAge() {
        assertEquals(14, visitor.getAge());
    }

    @Test
    public void hasHeight() {
        assertEquals(1.2, visitor.getHeight(), 0.1);
    }

    @Test
    public void hasMoney() {
        assertEquals(40.0, visitor.getMoney(), 0.1);
    }

    @Test
    public void canAddAttraction(){
        visitor.addAttraction(dodgems);
        visitor.addAttraction(park);
        visitor.addAttraction(rollerCoaster);
        assertEquals(Arrays.asList(dodgems, park, rollerCoaster), visitor.getVisitedAttractions());

    }
}
