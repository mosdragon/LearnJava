package edu.gatech.person;

import java.util.ArrayList;
import java.util.Collections;

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
        int diff = this.age - o.age;
        diff += -this.name.compareTo(o.name);
        return diff;
    }
    public static void main(String[] args) {
        ArrayList<Person> peeps = new ArrayList<>();
        peeps.add(new Person("Aara", 92));
        peeps.add(new Person("Harty", 43));
        peeps.add(new Person("Yaura", 75));
        for (Person p : peeps) {
            System.out.println(p);
        }
        System.out.println("\n\nHere we go!\n\n");
        Collections.sort(peeps);
        for (Person p : peeps) {
            System.out.println(p);
        }
    }
}