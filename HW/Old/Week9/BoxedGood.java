import java.text.NumberFormat;
/**
 * A BoxedGood is a type of GroceryItem that is sold in boxes.
 * It is also a Buyable since it extends GroveryItem,
 * and the cost is determined about the amount bought in boxes.
 * @author Muhammad Osama Sakhi
 * @version 1.0
 */
public class BoxedGood extends DryGood {
    private static NumberFormat form = NumberFormat.getCurrencyInstance();
    /**
     * The constructor passes a name and a price for the
     * BoxedGood object.
     * @param name, sets the name of the BoxedGood
     * @param price, the price of the BoxedGood
     */
    public BoxedGood(String name, double price) {
        super(name, price);
    }
    /**
     * Creates the String representation of the object
     * @return the String representation, formatted for BoxedGood objects
     */
    @Override
    public String toString() {
        String msg = String.format("%s @ %s per box", getName(),
            form.format(getPrice()));
        return msg;
    }
    /**
     * Creates a formatted string with the correct unit type for BoxedGood
     * objects.
     * @return a formatted String query
     */
    @Override
    public String getQuantityQuery() {
        String prompt = String.format("How many boxes of %s would you like?",
            getName());
        return prompt;
    }
}