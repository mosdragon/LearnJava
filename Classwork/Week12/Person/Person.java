import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.lang.Comparable;

public class Person implements Comparable<Person> {
    String name;
    int age;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String toString() {
        String msg = "This person's name is %s";
        msg+= " and her age is %d";
        return String.format(msg, name, age);
    }
    public int compareTo(Person o) {
        return o.age - this.age;
    }
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        } else if (!(o instanceof Person)) {
            return false;
        } else if (this == o) {
            return true;
        }
        Person p = (Person) o;
        return (this.age == p.age);
    }
}