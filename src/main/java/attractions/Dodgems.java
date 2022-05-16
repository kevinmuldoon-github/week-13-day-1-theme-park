package attractions;

import behaviours.ITicketed;
import people.Visitor;

public class Dodgems extends Attraction implements ITicketed {

    public Dodgems(String name, int rating) {
        super(name, rating);
    }

    @Override
    public double defaultPrice() {
        return 4.50;
    }

    @Override
    public double priceFor(Visitor visitor) {
        double price = 4.50;
        if (visitor.getAge() < 12) {
            price = 2.25;
        }
        return price;
    }
}
