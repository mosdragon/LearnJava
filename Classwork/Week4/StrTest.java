import java.util.Scanner;
public class StrTest {
    public static void main(String[] args){
        char letter = ';';
        System.out.printf("So the thing is here: |%s|%n",letter);
        //Because I don't use the keyword "new", java will think
        //That because I gave the same information, I want them 
        //To reference the same objects. Here it will print "true".
        String o1 = "osama";
        String o2 = "osama";
        System.out.println("Are o1 and o2 equal?\nAnswer:" + o1==o2);
        //This will print false since it knows that the "sakhi" in s1
        //Is not the same object I want to reference with s2 since I 
        //Used the keyword "new"
        String s1 = "sakhi";
        String s2 = new String("sakhi");
        System.out.println("Are s1 and s2 equal?\nAnswer:" + s1==s2);

        //This doesn't seem to be the case for other 
        Scanner f1 = new Scanner(System.in);
        Class c1 = f1.getClass();
        Class c2 = f1.getClass();
        //System.out.println(f1==f2);
    }
}