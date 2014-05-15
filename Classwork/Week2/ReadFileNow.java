import java.util.Scanner;
import java.io.File;
import java.io.PrintStream;

public class ReadFileNow {

    public static void main(String[] arg) throws Exception {

        Scanner gradeFile = new Scanner(new File("grades.txt"));
        while (gradeFile.hasNext()) {
            String line = gradeFile.nextLine();
            // do something with line
            System.out.println(line);
        }

        System.out.println("\n\n\n\nWe're done, fool!");
        boolean woo = false;
        System.out.println("\n\n\n\nWe're " + woo);


        PrintStream outFile = new PrintStream(new File("somefile.txt"));
        outFile.println("My name is doooody dude! And I'm >" + (8999 + 1));

    }
}