import java.util.Scanner;

public class LineFilter {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String text;
        while (input.hasNext()) {
            text = input.nextLine();
            if (args.length > 0 && text.contains(args[0])) {
                System.out.println(text);
            } else if (args.length == 0) {
                System.out.println(text);
            }
        }
    }
}