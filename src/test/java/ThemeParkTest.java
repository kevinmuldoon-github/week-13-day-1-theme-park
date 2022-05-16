import attractions.Dodgems;
import attractions.RollerCoaster;
import org.junit.Before;
import org.junit.Test;
import people.Visitor;
import stalls.CandyflossStall;
import stalls.IceCreamStall;
import stalls.ParkingSpot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ThemeParkTest {
    private Visitor visitor1, visitor2;

    private RollerCoaster rollerCoaster;
    private CandyflossStall candyflossStall;
    private Dodgems dodgems;
    private IceCreamStall iceCreamStall;

    private ThemePark themePark;

    private HashMap reviews;


    @Before
    public void before(){
        visitor1 = new Visitor(14, 140, 40.0);
        visitor2 = new Visitor(18, 160, 40.0);
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
        candyflossStall = new CandyflossStall("Candy Land", 4, "Harry Belafonte", ParkingSpot.A1);
        dodgems = new Dodgems("Bumper Cars", 5);
        iceCreamStall = new IceCreamStall("Dream Cones", 4, "Vanilla Ice", ParkingSpot.A4);
        themePark = new ThemePark();
        reviews = new HashMap();
    }

    @Test
    public void canAddItemToThemePark(){
        themePark.addItem(rollerCoaster);
        themePark.addItem(candyflossStall);
        themePark.addItem(dodgems);
        themePark.addItem(iceCreamStall);
        assertEquals(4, themePark.numberOfItems());
    }

    @Test
    public void canAccessItems(){
        themePark.addItem(rollerCoaster);
        themePark.addItem(candyflossStall);
        themePark.addItem(dodgems);
        themePark.addItem(iceCreamStall);
        assertEquals(Arrays.asList(rollerCoaster, candyflossStall, dodgems, iceCreamStall), themePark.getAllReviewed());
    }

    @Test
    public void canCreateVisit(){
        themePark.visit(visitor1, rollerCoaster);
        themePark.visit(visitor1, dodgems);
        themePark.visit(visitor2, rollerCoaster);
        assertEquals(2, rollerCoaster.getVisitCount());
        assertEquals(Arrays.asList(rollerCoaster, dodgems), visitor1.getVisitedAttractions());
    }

    @Test
    public void canBuildHashmap(){
        themePark.addItem(rollerCoaster);
        reviews.put("Blue Ridge", 10);
        assertEquals(reviews, themePark.getReviews());
    }

    @Test
    public void isVisitorAllowed(){
        themePark.addItem(rollerCoaster);
        themePark.addItem(candyflossStall);
        themePark.addItem(dodgems);
        themePark.addItem(iceCreamStall);
        assertEquals(Arrays.asList(candyflossStall, dodgems,iceCreamStall), themePark.getAllAllowedFor(visitor1));
    }
}
