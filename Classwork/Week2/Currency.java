import java.text.NumberFormat;
import java.util.Locale;

public class Currency {

    public static void main(String[] args) {

    NumberFormat us = NumberFormat.getCurrencyInstance();
    System.out.println(us.format(3.14));
    NumberFormat de = NumberFormat.getCurrencyInstance(Locale.ITALY);
    System.out.println(de.format(3.14));
     System.out.printf("Me gusta %1.2f %n", Math.PI);

    }
}