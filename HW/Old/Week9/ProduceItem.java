import java.text.NumberFormat;
/**
 * A ProduceItem is a type of GroceryItem that is sold by the pound.
 * It is also a Buyable since it extends GroveryItem,
 * and the cost is determined about the amount bought in pounds.
 * @author Muhammad Osama Sakhi
 * @version 1.0
 */
public class ProduceItem extends GroceryItem {
    private static NumberFormat form = NumberFormat.getCurrencyInstance();
    /**
     * The constructor passes a name and a price for the
     * ProduceItem object.
     * @param name, sets the name of the ProduceItem
     * @param price, the price of the ProduceItem
     */
    public ProduceItem(String name, double price) {
        super(name, price);
    }
    /**
     * Creates the String representation of the object
     * @return The String representation, formatted for ProduceItem objects
     */
    @Override
    public String toString() {
        String msg = String.format("%s @ %s per pound",
            getName(), form.format(getPrice()));
        return msg;
    }
    /**
     * Creates a formatted string with the correct unit type for ProduceItem
     * objects.
     * @return a formatted String query
     */
    @Override
    public String getQuantityQuery() {
        String prompt = String.format("How many pounds of %s would you like?",
            getName());
        return prompt;
    }
    /**
     * Calculates the cost of a certain number of a the ProduceItem object
     * @param quantity, the number of this ProduceItem to be bought
     * @return The quantity multiplied by the price, as a double
     */
    @Override
    public double getCostOf(int quantity) {
        return getPrice() * quantity;
    }
}