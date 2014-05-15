/**
 * This type is given to anything that can be eated for nutrition
 * @author Daniel Hay
 * @version 1.0
 */
public interface Edible {
    /**
     * Returns the nutritional value of the Edible
     */
    int getFoodPoints();
    boolean equals(Object o);
}
