/**
 * A ShoppingCartItem is a class that takes a Buyable item and stores
 * the quantity of that item bought. A new quantity for that item can
 * be set. Additionally, the cost of the quantity amount of the
 * ShoppingCartItem can be determined.
 * @author Muhammad Osama Sakhi
 * @version 1.0
 */
public class ShoppingCartItem {
    private Buyable item;
    private int qty;

    /**
     * Constructor for a ShoppingCartItem, takes in the Buyable item
     * and stores it with default quantity of 1.
     * @param item, the Buyable item to store
     */
    public ShoppingCartItem(Buyable item) {
        this.item = item;
        qty = 1;
    }
    /**
     * Sets new numeric quantity for the particular Buyable item
     * @param qty The quantity of items to be set for purchase
     */
    public void setQuantity(int qty) {
        this.qty = qty;
    }
    /**
     * calculates the cost of the quantity multiplied by the price of
     * the buyable item
     * @return the cost as a double
     */
    public double calculateCost() {
        return item.getCostOf(qty);
    }
    /**
     * Creates the String representation of the ShoppingCartItem, formatted
     * with both the item and it's quantity displayed.
     * @return The String representation, formatted for ShoppingCartItem
     */
    public String toString() {
        String msg = String.format(item + "\n\tx%d = $%.2f", qty,
            calculateCost());
        return msg;
    }
    /**
     * Determines the other Object is equal in value to this ShoppingCartItem
     * @param the other Object
     * @return true if they are equal in quantity and as Buyable objects,
     * false otherwise.
     */
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        } else if (this == other) {
            return true;
        } else if (!(other instanceof ShoppingCartItem)) {
            return false;
        }
        ShoppingCartItem that = (ShoppingCartItem) other;
        boolean allSame = true;
        if (!(this.item.equals(that.item)) || !(this.qty == that.qty)) {
            allSame = false;
        }
        return allSame;
    }
    /**
     * returns the hashCode from the Object class as an int
     * @return the hashCode, same as that from the super class
     */
    public int hashCode() {
        return super.hashCode();
    }
}