public class Company<T extends Employee> {
    private static class Employee {}

    private static class HourlyEmployee extends Employee {}

    private static class SummerIntern extends HourlyEmployee {}

    public Company() {
        System.out.println("Congrats!");
    }

    public static void main(String[] args) {
        Company<SummerIntern> sum = new Company<>();
    }
}