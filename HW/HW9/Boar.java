/**
 * This class represents a wild Boar. It is edible.
 * @author Muhammad Sakhi
 * @version 1.1
 */
public class Boar extends Animal implements Edible {
    private static final int FOODPOINTS = Nature.RAND.nextInt(6) + 25;
    private final int id = Nature.RAND.nextInt(Integer.MAX_VALUE);
    /**
     * Constructor for a Boar, creates a Boar object
     * @param home, a Home for the Boar
     */
    public Boar(Home home) {
        super("boar-100.png", home);
    }
    /**
     * Determines whether or not this Boar is equal to another Object
     * by value.
     * @param o, an Object
     * @return {@literal true} if equivalent, {@literal false} otherwise
     */
    public boolean equals(Object o) {
        return super.equals(o) && this.id == ((Boar) o).id;
    }
    /**
     * Returns the hashCode for this Boar
     * @return the hash code for this Boar
     */
    public int hashCode() {
        return super.hashCode() + this.id;
    }
    /**
     * Returns the value of points this Boar has as food.
     * @return FOODPOINTS, the value
     */
    public int getFoodPoints() {
        return FOODPOINTS;
    }
}
