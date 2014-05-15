public class MySimpleSetTester {

    public static void main(String ... args) {
        MonotonicSet<String> strings = new MySimpleSet<String>();
        strings.add("Hey!");
        strings.add("Hey!");
        strings.add("Hey!");
        strings.add("Hey!");
        strings.add("Hey!");
        strings.add("Listen!");
        strings.add("Sorry, I couldn't resist.");
        strings.add("Sorry, I couldn't resist.");
        strings.add("(you know you would if you could)");

        System.out.println("Testing toString:");
        System.out.println(strings);

        System.out.println("Testing size:");
        System.out.println(strings.size());

        MonotonicSet<Double> dubs = new MySimpleSet<Double>();
        dubs.add(2.0);
        dubs.add(4.0);
        dubs.add(4.2);
        dubs.add(4.2);
        dubs.add(4.2);
        dubs.add(2.0000000);

        System.out.println("Testing iterator:");
        for (Double d : dubs) {
            System.out.println(d);
        }
    }

}