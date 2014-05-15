import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.lang.Comparable;

public class CantCompare implements Comparable<CantCompare> {
    String name;
    int age;
    public CantCompare(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String toString() {
        String msg = "This person's name is %s";
        msg+= " and her age is %d";
        return String.format(msg, name, age);
    }
    public int compareTo(CantCompare o) {
        return o.age - this.age;
    }

    public static void main(String[] args) {
        ArrayList<CantCompare> peeps = new ArrayList<>();
        peeps.add(new CantCompare("Aara", 92));
        peeps.add(new CantCompare("Harty", 43));
        peeps.add(new CantCompare("Yaura", 75));
        for (CantCompare p : peeps) {
            System.out.println(p);
        }
        System.out.println("\n\nHere we go!\n\n");
        Collections.sort(peeps, new Comparator<CantCompare>() {
            public int compare(CantCompare a, CantCompare b) {
                return a.age - b.age;
            }
        });
        for (CantCompare p : peeps) {
            System.out.println(p);
        }

        //Now using Comparable
        System.out.println("\n\nHere we go!\n\n");
        Collections.sort(peeps);
        for (CantCompare p : peeps) {
            System.out.println(p);
        }
    }
}