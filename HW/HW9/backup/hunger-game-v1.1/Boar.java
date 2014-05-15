/**
 * This class represents a wild Boar.  It is edible.
 * @author Daniel Hay
 * @version 1.0
 */
public class Boar extends Animal implements Edible {
    private static final int FOODPOINTS = Nature.RAND.nextInt(6) + 25;
    private final int id = Nature.RAND.nextInt(Integer.MAX_VALUE);
    public Boar(Home home) {
        super("boar-100.png", home);
    }

    /**
     *
     */
    public boolean equals(Object o) {
        return super.equals(o) && this.id == ((Boar) o).id;
    }

    public int hashCode() {
        return super.hashCode() + this.id;
    }
}
