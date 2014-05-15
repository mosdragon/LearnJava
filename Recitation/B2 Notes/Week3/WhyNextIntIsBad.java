import java.util.Scanner;
public class WhyNextIntIsBad {

    public static void main(String[] args) {
        String ex = "This is why \n" + 
                     "nextInt() is bad: \n" + 
                     "42\n" +
                     "See the problem now?";

        Scanner myScan = new Scanner(ex);
        System.out.println("Without parseInt():");

        //Ideally, these should print:
        System.out.println(myScan.nextLine()); //This is why
        System.out.println(myScan.nextLine()); //nextInt() is bad:
        System.out.println(myScan.nextInt()); //42
        System.out.println(myScan.nextLine()); //See the problem now?

        //However the last one doesn't get printed. Explain why. (nextInt() leaves the \n character, making the next call return nothing)

        //See how this fixes everything:

        System.out.println("With parseInt():");
        
        Scanner betterScan = new Scanner(ex);
        System.out.println(betterScan.nextLine());
        System.out.println(betterScan.nextLine());
        System.out.println(Integer.parseInt(betterScan.nextLine()));
        System.out.println(betterScan.nextLine());



    }


}