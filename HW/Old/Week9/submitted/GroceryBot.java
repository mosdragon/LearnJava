import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.text.NumberFormat;
/**
 * A GroceryBot contains a GroceryBotItem array that serves as the inventory
 * for the store. Users using the GroceryBot are presented with options
 * for what to buy from the inventory. Any GroceryItem they want of any
 * gets added to their ShoppingCart. Additionally, when the user has
 * finished using GroceryBot, the receipt will be stored in the same directory
 * and be named "Recept.txt".
 * @author Muhammad Osama Sakhi
 * @version 1.0
 */
public class GroceryBot {
    // All of the static variables are created here. Upon checkout, the
    // Shopping cart is cleared too.
    private static final Scanner KEYBOARD = new Scanner(System.in);
    private static final String FILENAME = "Receipt.txt";
    private static NumberFormat form = NumberFormat.getCurrencyInstance();
    private static ShoppingCart cart = new ShoppingCart();
    private static GroceryItem[] inventory = {new ProduceItem("Red Apples",
        2.00), new BoxedGood("Admiral Crunch Cereal", 4.00),
        new CannedGood("Some Soup", 5.00)};

    public static void main(String[] args) {
        System.out.println("Welcome to the Grocery Store valued customer!\n");
        int choice = 0;
        do {
            System.out.print("What would you like to do?\n"
                + "1: Add item to cart\n" + "2: Remove item from cart\n"
                + "3: List cart contents\n" + "4: Checkout and Exit\n"
                + "Enter option number: ");
            choice = Integer.parseInt(KEYBOARD.nextLine());
            System.out.println();
            if (choice == 1) {
                GroceryBot.addItem();
            } else if (choice == 2) {
                GroceryBot.remove();
            } else if (choice == 3) {
                GroceryBot.contents();
            }
        } while (choice != 4);
        GroceryBot.checkout();
    }
    /**
     * First displays the inventory of items for purchase.
     * Then allows user to select which item to purchase and the quantity
     * of that item to purchase. Lastly, it shows the cart contents.
     */
    private static void addItem() {
        String msg = "We carry the following products:";
        for (int i = 0; i < inventory.length; i++) {
            msg += String.format("%n%d: %s", i + 1, inventory[i]);
        }
        System.out.println(msg);
        System.out.print("Enter the number of the"
            + " product you'd like to add, or -1 to cancel: ");
        int choice = Integer.parseInt(KEYBOARD.nextLine());
        System.out.println();
        int select;
        for (int i = 0; i < inventory.length; i++) {
            if (choice == (i + 1)) {
                msg += String.format("%n%d: %s", i, inventory[i]);
                ShoppingCartItem current = new ShoppingCartItem(inventory[i]);
                System.out.print(inventory[i].getQuantityQuery() + " ");
                select = Integer.parseInt(KEYBOARD.nextLine());
                current.setQuantity(select);
                System.out.println("Added item:\n" + current + "\n");
                cart.add(current);
            }
        }
        if ((choice > inventory.length || choice < 1) && choice != -1) {
            System.out.println("Invalid Input. Please Try Again.\n");
            GroceryBot.addItem();
        }
    }
    /**
     * Displays the items already in the user's ShoppingCart.
     */
    private static void contents() {
        System.out.println("Here are your cart contents:");
        System.out.println(cart);
    }
    /**
     * First displays the items already in the user's ShoppingCart.
     * Then allows user to select which item to remove by name and by quantity.
     * If the item matches an item in the cart, that item is removed from the
     * cart and the cart's contents are displayed.
     */
    private static void remove() {
        GroceryBot.contents();
        System.out.println("Enter the name of the product you want to remove:");
        String input = KEYBOARD.nextLine();
        boolean works = false;
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i].getName().equals(input)) {
                works = true;
            }
        }
        if (works) {
            System.out.println("\nEnter the quantity you want to remove:");
            int num = Integer.parseInt(KEYBOARD.nextLine());
            Buyable junk = new BoxedGood(input, 1.99);
            ShoppingCartItem rem = new ShoppingCartItem(junk);
            rem.setQuantity(num);
            System.out.println();
            try {
                cart.remove(rem);
                GroceryBot.contents();
            } catch (Exception e) {
                System.out.println("\nI'm sorry, I'm afraid I can't"
                    + " do that. No such item found...\n");
            }
        } else {
            System.out.println("\nI'm sorry, I'm afraid I can't"
                + " do that. No such item found...\n");
        }
    }
    /**
     * Gives a message to the terminal indicating to the user that the
     * GroceryBot program is about to terminate and that the cart and the
     * total will be stored in a file called "Receipt.txt".
     */
    private static void checkout() {
        System.out.print("Thank you! Please take your "
            + "receipt (see Receipt.txt)");
        try {
            String msg = "Grocery Store Receipt\n\n";
            msg += "Here are your purchases:\n" + cart;
            msg += String.format("\nTotal = %s", form.format(cart.getTotal()));
            msg += "\n\nThank You!";
            msg = msg.replace("\n", "\r\n");
            File file = new File(FILENAME);
            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter writer = new FileWriter(file.getAbsoluteFile());
            BufferedWriter buff = new BufferedWriter(writer);
            buff.write(msg);
            //Closes out the BufferedWriter
            buff.close();
            cart = new ShoppingCart();
// Using tutorial on
//http://www.mkyong.com/java/how-to-write-to-file-in-java-bufferedwriter-examp
//le/
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}