/**
 * This interface represents an endangered species type
 * @author Muhammad Sakhi
 * @version 9.0001
 */
public interface EndangeredSpecies {
    /**
     * Returns the wanted level associated with the Endangered Species
     * @return the wanted level
     */
    int getWantedLevel();
    /**
     * Determines whether another Object is equivalent to this Object
     * @param o, another Object
     * @return {@literal true} if they are equivalent, {@literal false}
     * otherwise.
     */
    boolean equals(Object o);
}
