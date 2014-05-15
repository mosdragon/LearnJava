/**
 * This type is given to anything that can be eated for nutrition
 * @author Daniel Hay
 * @version 1.0
 */
public interface Edible {
    /**
     * Returns the nutritional value of the Edible
     * @return the nutritional value
     */
    int getFoodPoints();
    /**
     * Determines whether another Object is equivalent to this Object
     * @param o, another Object
     * @return {@literal true} if they are equivalent, {@literal false}
     * otherwise.
     */
    boolean equals(Object o);
}
