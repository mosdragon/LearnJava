import java.util.Calendar;
import java.util.Locale;

public class Formatting {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        System.out.format("Today's date: %tB %te, %tY%n" +
                          "Current time: %tl:%tM%n", c, c, c, c, c);
    }
}