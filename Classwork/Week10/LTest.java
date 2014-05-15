import java.util.ArrayList;

public class LTest {
    public static void main(String[] args) throws Throwable{
        /*ArrayList str = new ArrayList<String>(2);
        str.add(new String("whoo"));
        str.add(new String("whoo"));
        str.add("booyah!");
        str.add("Person@deadbeef");
        System.out.println("First time:");
        for (Object o : str) {
            String s = (String) o;
            System.out.println(s);
        }
        str.remove(new String("whoo"));
        System.out.println("Hope this works:");
        for (Object o : str) {
            String s = (String) o;
            System.out.println(s);
        }*/
        /*try {
            foo();
        } catch(Throwable t) {
            System.out.println("B");
            System.out.println(t.getMessage());
        }*/
        foo();
        System.out.println("!");
    }
    public static void foo() throws Throwable{
        try {
            bar();
        } catch(Exception e) {
            System.out.println("C");
        }
        throw new Exception("Meow!");
    }
    public static void bar() throws Throwable {
        try {
            baz();
        } catch(Throwable t) {
            System.out.println("B");
        }
        throw new Throwable("A");
    }
    public static void baz() throws Throwable{
        System.out.println("A");
        throw new Throwable();
    }




}