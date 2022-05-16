package stalls;

import behaviours.ISecurity;
import people.Visitor;

public class TobaccoStall extends Stall implements ISecurity {

    public TobaccoStall(String name, int rating, String ownerName, ParkingSpot parkingSpot) {
        super(name, rating, ownerName, parkingSpot);
    }


    public boolean isAllowedTo(Visitor visitor) {
        boolean status =  true;

        if (visitor.getAge() <18) {
            status = false;
        }

        return status;
    }
}
