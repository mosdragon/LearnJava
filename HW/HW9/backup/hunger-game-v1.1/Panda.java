/**
 * Represents a Panda: an Animal that is an endangered species
 * @author Daniel Hay
 * @version 1.0
 */
public class Panda extends Animal implements EndangeredSpecies {
    private final int wantedLevel = Nature.RAND.nextInt(2) + 1;
    private final int id = Nature.RAND.nextInt(Integer.MAX_VALUE);
    public Panda(Home home) {
        super("panda-100.png", home);
    }
    public boolean equals(Object o) {
        return super.equals(o) && this.id == ((Panda) o).id;
    }

    public int hashCode() {
        return super.hashCode() + this.id;
    }
}
