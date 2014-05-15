/**
 * A ShoppingCart contains a ShoppingCartItem array that stores Buyable
 * items (and their quantities). These items can be added or removed from the
 * ShoppingCart and a String representation of the ShoppingCart can be
 * generated.
 * @author Muhammad Osama Sakhi
 * @version 1.0
 */
public class ShoppingCart {
    private ShoppingCartItem[] products;
    /**
     * Constructor for ShoppingCart initializes the ShoppingCartItem array
     * iniatially to a length of 10.
     */
    public ShoppingCart() {
        products = new ShoppingCartItem[10];
    }
    /**
     * Adds a ShoppingCartItem to the array. If the array is already
     * full, the size of the array is doubled and the parameter is added
     * as the next element. Otherwise, if the array has space, the item is
     * placed in the next empty spot.
     * @param item, the ShoppingCartItem to add to the array
     */
    public void add(ShoppingCartItem item) {
        int size = products.length;
        if (products[size - 1] == null) {
            boolean placed = false;
            for (int i = 0; i < size; i++) {
                if ((products[i] == null) && !placed) {
                    products[i] = item;
                    placed = !placed;
                }
            }
        } else {
            ShoppingCartItem[] temp = products;
            products = new ShoppingCartItem[size * 2];
            for (int i = 0; i < size; i++) {
                products[i] = temp[i];
            }
            products[size] = item;
        }
    }
    /**
     * Removes a ShoppingCartItem from the backing array if a match for the
     * input item is found, and returns that item from the array. Otherwise,
     * null is returned. If the element is removed from the backing array, all
     * subsequent elements must be shifted up by one.
     * @param item, the ShoppingCartItem to remove from the backing array
     * @return if a match is found, the element from the array. Otherwise, null
     */
    public ShoppingCartItem remove(ShoppingCartItem item) {
        ShoppingCartItem removed = null;
        if (item == null) {
            return removed;
        }
        boolean found = false;
        int size = products.length;
        for (int i = 0; i < size; i++) {
            if (!found && products[i].equals(item)) {
                found = true;
                removed = products[i];
            }
            if (found) {
                if (i < size - 1) {
                    products[i] = products[i + 1];
                } else if (i == size) {
                    products[i] = null;
                }
            }
        }
        return removed;
    }
    /**
     * Creates the String representation of the ShoppingCart object
     * @return The String representation, formatted for ShoppingCart objects
     */
    public String toString() {
        String msg = "";
        for (ShoppingCartItem i : products) {
            if (i != null) {
                msg += i + "\n";
            }
        }
        return msg;
    }
    /**
     * Goes through each element of the ShoppingCartItem array and adds up
     * the cost of each item to return it as a double.
     * @return the total cost of all the ShoppingCartItems together, as a
     * double.
     */
    public double getTotal() {
        double total = 0;
        for (ShoppingCartItem i : products) {
            if (i != null) {
                total += i.calculateCost();
            }
        }
        return total;
    }
}