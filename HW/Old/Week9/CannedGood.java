import java.text.NumberFormat;
/**
 * A CannedGood is a type of GroceryItem that is sold in cans.
 * It is also a Buyable since it extends GroveryItem,
 * and the cost is determined about the amount bought in cans.
 * @author Muhammad Osama Sakhi
 * @version 1.0
 */
public class CannedGood extends GroceryItem {
    private static final double SPECIAL = 3;
    private static NumberFormat form = NumberFormat.getCurrencyInstance();
    /**
     * The constructor passes a name and a price for the
     * CannedGood object.
     * @param name, sets the name of the CannedGood
     * @param price, the price of the CannedGood
     */
    public CannedGood(String name, double price) {
        super(name, price);
    }
    /**
     * Creates the String representation of the object
     * @return the String representation, formatted for CannedGood objects
     */
    @Override
    public String toString() {
        String msg = String.format("%s @ %s per can, buy 2 get 1 free",
            getName(), form.format(getPrice()));
        return msg;
    }
    /**
     * Creates a formatted string with the correct unit type for CannedGood
     * objects.
     * @return a formatted String query
     */
    @Override
    public String getQuantityQuery() {
        String prompt = String.format("How many cans of %s would you like?"
            + " Buy 2, get 1 free!", getName());
        return prompt;
    }
    /**
     * Calculates the cost of a certain number of a the CannedGood object
     * @param quantity, the number of this CannedGood to be bought
     * @return The quantity multiplied by the price, as a double
     */
    @Override
    public double getCostOf(int quantity) {
        if (quantity >= SPECIAL) {
            double discounted = Math.floor(quantity / SPECIAL);
            return getPrice() * (quantity - discounted);
        } else {
            return getPrice() * quantity;
        }
    }
    // Testing
    /*public static void main(String[] args) {
        CannedGood b = new CannedGood("Tuna", 2);
        System.out.println(b);
        System.out.println(b.getQuantityQuery());
        System.out.println(b.getCostOf(3));
        System.out.println(b.getCostOf(4));
    }*/
}