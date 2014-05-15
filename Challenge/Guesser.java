import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.File;

public class Guesser {
    public static void main(String[] args) throws Exception {
        Scanner doc = new Scanner(new File(args[0]));
        String str = new String();
        if (doc.hasNextLine()) {
            str = doc.nextLine();
        }
        int max = Integer.parseInt(str);
        int[] record = new int[max];
        boolean[] sameLine = new boolean[max];

        while (doc.hasNextLine()) {
            str = doc.nextLine();
            StringTokenizer tok = new StringTokenizer(str);
            while (tok.hasMoreTokens()) {
                String temp = tok.nextToken();
                int val = Integer.parseInt(temp);
                if (!sameLine[val - 1]) {
                    record[val - 1]++;
                    sameLine[val - 1] = true;
                }
            }
            sameLine = new boolean[max];
        }
        ArrayList<Integer> results = arrMax(record);
        if (results.size() > 1) {
            System.out.println("Unable to determine which number was selected");
        } else {
            System.out.println(results.get(0) + " Is the number you guessed");
        }
    }

    private static ArrayList<Integer> arrMax(int[] arr) {
        ArrayList<Integer> works = new ArrayList<Integer>();
        final int max = 4;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] >= max) {
                works.add(i + 1);
            }
        }
        return works;
    }   
}