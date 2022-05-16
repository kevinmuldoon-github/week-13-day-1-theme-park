package attractions;

import behaviours.ISecurity;
import people.Visitor;

public class Playground extends Attraction implements ISecurity {

    public Playground(String name, int rating) {
        super(name, rating);
    }

    public boolean isAllowedTo(Visitor visitor) {
        boolean status = true;

        if (visitor.getAge() > 15) {
            status = false;
        }

        return status;
    }
}
