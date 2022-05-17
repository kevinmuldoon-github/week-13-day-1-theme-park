import attractions.Attraction;
import attractions.RollerCoaster;
import behaviours.IReviewed;
import behaviours.ISecurity;
import people.Visitor;

import java.util.ArrayList;
import java.util.HashMap;

public class ThemePark {

    private ArrayList<IReviewed> items;
    private HashMap<String, Integer> reviews;

    public ThemePark() {
        this.items = new ArrayList<>();
        this.reviews = new HashMap();
    }
    public ArrayList<IReviewed> getAllReviewed(){
        return items;
    }

    public HashMap<String, Integer> getReviews() {
        return reviews;
    }

    public void addItem(IReviewed item){
        items.add(item);
        buildHashMap(item);
    }

    public int numberOfItems(){
        return items.size();
    }

    public void visit(Visitor visitor, Attraction attraction){
        attraction.increaseVisitCount();
        visitor.addAttraction(attraction);
    }

    public void buildHashMap(IReviewed item) {
        String itemName = item.getName();
        Integer itemRating = item.getRating();
        this.reviews.put(itemName, itemRating);
    }

    public ArrayList<IReviewed> getAllAllowedFor(Visitor visitor){
    ArrayList<IReviewed> allowed = new ArrayList<>(); // new empty array to store allowed attractions and stalls

    for (IReviewed item: items) { // loop through items

        if (item instanceof ISecurity) { // Does the item implement ISecurity?
            if (((ISecurity) item).isAllowedTo(visitor)){ // If visitor is allowed on attraction/stall
                allowed.add(item); // add item to allowed list
            } // end if

        } // end if
    }
        return allowed;
    }
}
