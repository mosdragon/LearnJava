/**
 * Represents a Shark: an Animal that is an endangered species
 * @author Muhammad Sakhi
 * @version 9001
 */
public class Shark extends Animal implements EndangeredSpecies {
    private final int wantedLevel = Nature.RAND.nextInt(2) + 1;
    private final int id = Nature.RAND.nextInt(Integer.MAX_VALUE) + 3;
    /**
     * Constructor for a Shark, creates a Shark object
     * @param home, a Home for the Shark
     */
    public Shark(Home home) {
        super("sharky.png", home);
    }
    /**
     * Determines whether or not this Shark is equal to another Object
     * by value.
     * @param o, an Object
     * @return {@literal true} if equivalent, {@literal false} otherwise
     */
    public boolean equals(Object o) {
        return super.equals(o) && this.id == ((Shark) o).id;
    }
    /**
     * Returns the hashCode for this Shark
     * @return the hash code for this Shark
     */
    public int hashCode() {
        return super.hashCode() + this.id;
    }
    /**
     * Returns the value of points this Shark has as food.
     * @return FOODPOINTS, the value
     */
    public int getWantedLevel() {
        return wantedLevel;
    }
}
