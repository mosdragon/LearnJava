import java.util.ArrayList;
import java.util.Iterator;
import java.awt.Point;
/**
 * A MySimpleSet is a set that implements MonotonicSet. It is a non-decreasing
 * monotonic set because no element in the set can be a duplicate of any other
 * element. Additionally, no element can be removed from the set, elements can
 * only be added. Therefore, it is a non-decreasing set.
 * @author Muhammad Osama Sakhi
 * @version 1.0
 */
public class MySimpleSet<E> implements MonotonicSet<E> {

    private ArrayList<E> arr;
    /**
     * Constructor for the MySimpleSet. Takes no parameters. Initializes
     * the ArrayList to a generic type E.
     */
    public MySimpleSet() {
        arr = new ArrayList<E>();
    }
    /**
     * Adds an element to the set only if the element is not a duplicate
     * of an entry already in the set.
     * @param element, an object of generic type E
     */
    @Override
    public void add(E element) {
        if (!found(element)) {
            arr.add(element);
        }
    }
    /**
     * Returns the size of the set.
     * @return the size of the set
     */
    @Override
    public int size() {
        return arr.size();
    }
    /**
     * Returns an Iterator of type E. Allows the driver class
     * to iterate through the set using an enhanced for loop.
     * @return the Iterator of the generic type E.
     */
    @Override
    public Iterator<E> iterator() {
        Iterator<E> done = arr.iterator();
        return done;
    }
    /**
     * Private helper method that determines whether an element is already
     * a member of the set.
     * @param element, an object of generic type E.
     * @return true if element is a duplicate of an object in the set. false
     * otherwise.
     */
    private boolean found(E element) {
        boolean found = false;
        for (E curr : arr) {
            if (curr.equals(element)) {
                found = true;
            }
        }
        return found;
    }
    /**
     * Provides a String representation of the set
     * @return the String representation of the set
     */
    @Override
    public String toString() {
        String msg = "[";
        for (E data : arr) {
            msg += data + ", ";
        }
        msg = msg.substring(0, msg.length() - 2) + "]";
        return msg;
    }
    /**
     * Provides a hash consistent with every use of a particular MySimpleSet
     * object.
     * @return a hash code consistent for every driver class that uses
     * MySimpleSet objects.
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }
    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<String>();
        arr.add("yeah!");
        arr.add("I'm");
        arr.add("osama");
        System.out.println(arr.contains(new String("osama")));
        ArrayList<Point> arr2 = new ArrayList<Point>();
        Point p1 = new Point(5,1);
        arr2.add(new Point(1,2));
        arr2.add(p1);
        System.out.println(arr2.contains(new Point(1,2)));
    }
}