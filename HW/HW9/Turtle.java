/**
 * This class represents a wild Turtle.  It is edible.
 * @author Muhammad Sakhi
 * @version 1.0
 */
public class Turtle extends Animal implements Edible {
    private static final int FOODPOINTS = Nature.RAND.nextInt(6) + 10;
    private final int id = Nature.RAND.nextInt(Integer.MAX_VALUE) + 1;
    /**
     * Constructor for a Turtle, creates a Turtle object
     * @param home, a Home for the Turtle
     */
    public Turtle(Home home) {
        super("dude.png", home);
    }
    /**
     * Determines whether or not this Turtle is equal to another Object
     * by value.
     * @param o, an Object
     * @return {@literal true} if equivalent, {@literal false} otherwise
     */
    public boolean equals(Object o) {
        return super.equals(o) && this.id == ((Turtle) o).id;
    }
    /**
     * Returns the hashCode for this Turtle
     * @return the hash code for this Turtle
     */
    public int hashCode() {
        return super.hashCode() + this.id;
    }
    /**
     * Returns the value of points this Turtle has as food.
     * @return FOODPOINTS, the value
     */
    public int getFoodPoints() {
        return FOODPOINTS;
    }
}
