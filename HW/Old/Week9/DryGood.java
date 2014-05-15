import java.text.NumberFormat;
/**
 * A DryGood is a type of GroceryItem that is sold in units.
 * It is also a Buyable since it extends GroveryItem,
 * and the cost is determined about the amount bought in units.
 * @author Muhammad Osama Sakhi
 * @version 1.0
 */
public class DryGood extends GroceryItem {
    private static NumberFormat form = NumberFormat.getCurrencyInstance();
    /**
     * The constructor passes a name and a price for the
     * DryGood object.
     * @param name, sets the name of the DryGood
     * @param price, the price of the DryGood
     */
    public DryGood(String name, double price) {
        super(name, price);
    }
    /**
     * Creates the String representation of the object
     * @return the String representation, formatted for DryGood objects
     */
    @Override
    public String toString() {
        String msg = String.format("%s @ %s per unit", getName(),
            form.format(getPrice()));
        return msg;
    }
    /**
     * Creates a formatted string with the correct unit type for DryGood
     * objects.
     * @return a formatted String query
     */
    @Override
    public String getQuantityQuery() {
        String prompt = String.format("How many units of %s would you like?",
            getName());
        return prompt;
    }
    /**
     * Calculates the cost of a certain number of a the DryGood object
     * @param quantity, the number of this DryGood to be bought
     * @return The quantity multiplied by the price, as a double
     */
    @Override
    public double getCostOf(int quantity) {
        return getPrice() * quantity;
    }
}