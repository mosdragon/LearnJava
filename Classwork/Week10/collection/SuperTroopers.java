import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.Comparable;

public class SuperTroopers {

    private static class Trooper extends SuperTrooper implements Comparable<Trooper> {

        private String name;
        private boolean mustached;
        
        public Trooper(String name, boolean hasMustache) {
            this.name = name;
            //super(name);
            setMustache(hasMustache);
        }

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public boolean hasMustache() { return mustached; }
        public void setMustache(boolean hasMustache) {
            this.mustached = hasMustache;
        }
        public String toString() {
            return getName() + (hasMustache() ? " :-{" : " :-|");
        }

        public int compareTo(Trooper other) {
            return this.name.compareTo(other.name);
        }

        public boolean equals(Object other) {
            if (null == other) return false;
            if (this == other) return true;
            if (!(other instanceof Trooper)) return false;
            Trooper that = (Trooper) other;
            return super.equals(that) && this.mustached == that.mustached;
        }

        public int hashCode() {
            return super.hashCode() + (hasMustache() ? 1 : 0);
        }
    }

    public static void main(String[] args) {
        ArrayList<Trooper> troopers = new ArrayList<>();
        troopers.add(new Trooper("Thorny", true));
        troopers.add(new Trooper("Farva", true));
        troopers.add(new Trooper("Farva", true));
        troopers.add(new Trooper("Rabbit", false));
        troopers.add(new Trooper("Mac", true));
        troopers.add(new Trooper("Foster", true));

        System.out.println("Before sorting:\n" + troopers);
        
        // Note that sort() is destructive, that is, it modifies the
        // collection rather than returning a sorted copy.
        Collections.sort(troopers);
        System.out.println("\nAfter sorting:\n" + troopers);

        // Notice that you can create a new collection by passing an
        // existing collection to the constructor.  This is a
        // convention in the collections framework, but is not
        // guaranteed by any language feature of Java.
        Set<Trooper> trooperSet = new HashSet<>(troopers);

        // Notice that duplicates are removed, which is good, 'cuz who
        // needs two Farvas?
        System.out.println("\nAs a set:\n" + trooperSet);

        // Mac is in the set, but we don't find him because we didn't
        // override hashCode().
        System.out.println("\nOops!  Didn't override hashCode():");
        System.out.println("trooperSet.contains(new Trooper(\"Mac\", true))="
                           + trooperSet.contains(new Trooper("Mac", true)));
    }
    
}
