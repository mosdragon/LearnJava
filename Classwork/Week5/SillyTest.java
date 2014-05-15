import java.util.Scanner;
import java.awt.Point;
public class SillyTest {
    public static void main(String[] args){
        //char letter = ';';
       // System.out.printf("So the thing is here: |%s|%n",letter);
        //Because I don't use the keyword "new", java will think
        //That because I gave the same information, I want them 
        //To reference the same objects. Here it will print "true".
        String o1 = "osama";
        String o2 = "osama";
        System.out.println("Are o1 and o2 equal? Answer:\t" + (o1 == o2));
        //This will print false since it knows that the "sakhi" in s1
        //Is not the same object I want to reference with s2 since I 
        //Used the keyword "new"
        String s1 = "sakhi";
        String s2 = new String("sakhi");
        System.out.println("Are s1 and s2 equal? Answer:\t" + (s1 == s2));

        //This also works when you call the same method on the same object
        //It will reference the same object. 
        Scanner key1 = new Scanner(System.in);
        Class c1 = key1.getClass();
        Class c2 = key1.getClass();
        //Don't worry about what the object "Class" does, I honestly
        //Have no clue. This is just to show it works for more than just Strings.
        System.out.println("Are c1 and c2 the same? Answer:\t" + (c1==c2));

        //Here, the keyword "new" is super important again
        Scanner key2 = new Scanner(System.in);
        System.out.println("Are key1 and key2 the same? Answer:\t" + (key1==key2));

        //Conversely, if we "copy" another object, we are actually referencing the original
        String toCopy = "I'm silly";
        String copy = toCopy;
        System.out.println("Are toCopy and copy referencing the same thing? Ans:\t" + (toCopy==copy));

        //The changes don't seem to happen to both though
        copy += ", and my name is Osama";
        System.out.println("\n\nLet's try adding something to one.\nHere's copy: " + copy);
        System.out.println("And here's toCopy: " + toCopy);

        //And again
        copy = toCopy;
        copy = copy.toUpperCase();
        System.out.println("\n\n\nNow lets just make one uppercase.\nHere's copy: " + copy);
        System.out.println("And here's toCopy: " + toCopy);

        //Reference types aside from String
        Point p1 = new Point(2,2);
        Point p2 = p1;
        p2.setLocation(5,5);
        System.out.println("\n\nThe location of p1 is: " + p1);
        System.out.println("The location of p2 is: " + p2);

        p2 = new Point(2,2);
        System.out.println("\n\nThe location of p1 is: " + p1);
        System.out.println("The location of p2 is: " + p2);
    }
}