private class Employee {}

private class HourlyEmployee extends Employee {}

private class SummerIntern extends HourlyEmployee {}

public class Company<T extends Employee> {
    public static void main(String[] args) {
        Company<SummerIntern> sum = new Company<>();
    }
}