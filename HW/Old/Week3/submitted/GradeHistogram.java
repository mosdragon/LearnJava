import java.util.Scanner;
import java.io.File;

public class GradeHistogram {
    public static void main(String[] args) throws Exception {
        String filename = args[0];
        Scanner file = new Scanner(new File(filename));
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Grades loaded!\nWhat bucket size would you like?"
                        + "\n>>> ");
        // The number of ranges' calculation goes here.
        // Math.abs makes it always positive.
        final int max = 100;
        int bucket = Math.abs(Integer.parseInt(keyboard.nextLine()));
        // Since 101 is a prime number, the size of the array (ranges) must be
        // Rounded up
        int ranges = (int) (Math.ceil((double) (max + 1) / bucket));
        int[] count = new int[ranges];
        int val = file.nextInt();
        int upper;
        int lower;
        //Size of the bucket being checked. creating a new variable "size" is
        //more precise than referencing bucket repeatedly.
        final int size = bucket;
        // Loop goes through each index, asseses the high and low for the
        //desired range using the index. Incrememnts the counter for that
        // index if val is within the upper and lower bounds. Afterwards, a
        //new value is found and the index is reset to -1 (and 0 immediately
        //within the loop).
        int j = -1;
            while (j < count.length) {
                j++;
                upper = max - (size * j);
                lower = max - (size * (j + 1));
                lower = (lower <= 0) ? -1 : lower;
                if (val > lower && val <= upper) {
                    count[j] += 1;
                    if (file.hasNextLine()) {
                        val = Integer.parseInt(file.next());
                        j = -1;
                    }
                }
            }
        // All code for formatted print goes here.
        System.out.println();
        //variable key will keep track of the number of times the brackets need
        // to be made.
        int k = 0;
        String key = new String("");
        while (k < count.length) {
            for (int n = 1; n <= count[k]; n++) {
                key += "[]";
            }
            upper = max - (size * k);
            lower = upper - size;
            lower = (lower < 0) ? 0 : lower + 1;
            String lowBound = String.format("%d", lower);
            String highBound = String.format("%d", upper);
            System.out.printf("%3s - %3s | %s%n", highBound, lowBound, key);
            key = new String();
            k++;
        }
    }
}