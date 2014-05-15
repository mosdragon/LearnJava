import java.text.SimpleDateFormat;
import java.util.Calendar;

public class GoodTime {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        cal.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        System.out.println( sdf.format(cal.getTime()));
        long b4 = System.currentTimeMillis();
        System.out.println(b4);
        try {
            Thread.sleep(1000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        long now = System.currentTimeMillis();
        System.out.println(now);
    }
}