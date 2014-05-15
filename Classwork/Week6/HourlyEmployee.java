public class HourlyEmployee extends Employee {
    protected boolean fancy = true;

    public String toString() {
        String yee = String.format("%s is %d years old, but he sure is fancy, right? ", name, age);
        return yee+fancy+"\n";
    }

    public static void main(String[] args) {
        HourlyEmployee o = new HourlyEmployee();
        System.out.print(o);
    }
}