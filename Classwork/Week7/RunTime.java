import java.util.Calendar;
import java.util.Scanner;

public class RunTime {
    private Calendar cal;
    private long start;
    private long stop;
    private long diff = 0;
    private boolean running;


    public void start() {
        running = true;
        cal = Calendar.getInstance();
        start = cal.getTimeInMillis();
    }
    public void stop() {
        if (running) {
            running = false;
            stop = cal.getTimeInMillis();
            diff = stop - start;
        } else {
            String msg = "Silly goose, you never started!";
            throw new IllegalArgumentException(msg);
        }
    }
    public String toString() {
        return String.format("The time elapsed is: %d milliseconds", diff);
    }

    public static void main(String[] args) {
        RunTime rt = new RunTime();
        rt.start();
        Scanner s = new Scanner(System.in);
        String z = s.nextLine();
        rt.stop();
        System.out.println(rt);
    }

}