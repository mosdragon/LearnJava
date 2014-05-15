import java.util.Scanner;

public class Dummy {

    public static void main(String[] arg) {

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter your 3 test scores, separated by"
                            + "spaces.");
        int exam1 = keyboard.nextInt();
        int exam2 = keyboard.nextInt();
        int exam3 = keyboard.nextInt();
        double examAvg = (exam1 + exam2 + exam3) / 3.0; // Why 3.0 instead 0
        System.out.printf("Your exam average is %.1f%n", examAvg);


         System.out.println("Let's try again");
        String token1 = keyboard.next();
        System.out.println("The token is " + token1);
        exam1 = Integer.parseInt(token1);
          System.out.println("Twice your token is  " + 2*exam1);

	}
}