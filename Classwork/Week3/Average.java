public class Average {
    public static void main(String[] args) {
        double total = 0.0;
        double avg = 0.0;;
        if (args.length > 0) {
            for (String s : args) {
                total += Double.parseDouble(s);
            }
            avg = total/args.length;
        }
        System.out.printf("%3.2f",avg);
    }
}