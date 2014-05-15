/**
 * Represents a Panda: an Animal that is an endangered species
 * @author Muhammad Sakhi
 * @version 1.0
 */
public class Panda extends Animal implements EndangeredSpecies {
    private final int wantedLevel = Nature.RAND.nextInt(2) + 1;
    private final int id = Nature.RAND.nextInt(Integer.MAX_VALUE);
    /**
     * Constructor for a Panda, creates a Panda object
     * @param home, a Home for the Panda
     */
    public Panda(Home home) {
        super("panda-100.png", home);
    }
    /**
     * Determines whether or not this Panda is equal to another Object
     * by value.
     * @param o, an Object
     * @return {@literal true} if equivalent, {@literal false} otherwise
     */
    public boolean equals(Object o) {
        return super.equals(o) && this.id == ((Panda) o).id;
    }
    /**
     * Returns the hashCode for this Panda
     * @return the hash code for this Panda
     */
    public int hashCode() {
        return super.hashCode() + this.id;
    }
    /**
     * Returns the value of points this Panda has as food.
     * @return FOODPOINTS, the value
     */
    public int getWantedLevel() {
        return wantedLevel;
    }
}
