import java.util.ArrayList;

public class AListDemo {
    public static void main(String[] args) {
        ArrayList ints = new ArrayList<Integer>();
        ints.add(99);
        ints.add(11);
        ints.add(55);
        ints.add(1000);

        for (Object n : ints) {
            int num = (Integer) n;
            System.out.println(++num);
        }
    }
}