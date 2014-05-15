import java.util.Scanner;
import java.text.NumberFormat;
import java.util.Locale;

public class CodingAnswers{
    public static void main(String... args){
        Scanner s = new Scanner(System.in);
        System.out.print("Please enter an amount in dollars: $");
        double amount = Double.parseDouble(s.nextLine());
        NumberFormat euro = NumberFormat.getCurrencyInstance(Locale.FRANCE);
        System.out.println(euro.format(amount*0.76));
    
    }
}