import attractions.Attraction;
import behaviours.IReviewed;
import people.Visitor;

import java.util.ArrayList;

public class ThemePark{

    private ArrayList<IReviewed> items;

    public ThemePark() {
        this.items = new ArrayList<>();
    }
    public ArrayList<IReviewed> getAllReviewed(){
        return items;
    }

    public void addItem(IReviewed item){
        items.add(item);
    }

    public int numberOfItems(){
        return items.size();
    }

    public void visit(Visitor visitor, Attraction attraction){
        attraction.increaseVisitCount();
        visitor.addAttraction(attraction);
    }

}
