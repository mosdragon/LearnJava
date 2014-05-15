import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.lang.Comparable;

public class LostPerson extends Person {
    private boolean isChubby;
    public LostPerson(String name, int age) {
        super(name, age);
        isChubby = true;
    }
    public void setChubby(boolean b) {
        isChubby = b;
    }
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        } else if (!(o instanceof Person)) {
            return false;
        } else if (this == o) {
            return true;
        }
        LostPerson p = (LostPerson) o;
        return (this.isChubby == p.isChubby);
    }

    public static void main(String[] args) {
        ArrayList<Person> peeps = new ArrayList<>();
        peeps.add(new Person("Osama", 19));
        LostPerson osama = new LostPerson("Osama", 19);
        peeps.add(osama);
        osama.setChubby(false);

        System.out.println(peeps.contains(new Person("Osama", 19)));
    }
}