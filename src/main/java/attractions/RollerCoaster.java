package attractions;

import behaviours.ISecurity;
import behaviours.ITicketed;
import people.Visitor;

public class RollerCoaster extends Attraction implements ISecurity, ITicketed {

    public RollerCoaster(String name, int rating) {
        super(name, rating);
    }

    public boolean isAllowedTo(Visitor visitor) {
        boolean status = true;

        if (visitor.getHeight() < 145 || visitor.getAge() < 12) {
            status=false;
        }

        return status;
    }

    public double defaultPrice() {
        return 8.4;
    }

    public double priceFor(Visitor visitor) {
        double price = 8.4;
        if (visitor.getHeight() >200) {
            price = 16.80;
        }
        return price;
    }


}
