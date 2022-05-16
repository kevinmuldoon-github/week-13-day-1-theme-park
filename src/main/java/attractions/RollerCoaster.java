package attractions;

import behaviours.ISecurity;
import people.Visitor;

public class RollerCoaster  extends Attraction implements ISecurity {

    public RollerCoaster(String name, int rating) {
        super(name, rating);
    }

    @Override
    public boolean isAllowedTo(Visitor visitor) {
        boolean status = true;

        if (visitor.getHeight() < 145 || visitor.getAge() < 12) {
            status=false;
        }

        return status;
    }
}
