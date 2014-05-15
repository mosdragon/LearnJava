import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

public class HourlyEmployee extends Employee {

    private double hourlyWage;
    private final double monthlyHours;

    public HourlyEmployee(HourlyEmployee other) {
        super(other);
        this.hourlyWage = other.hourlyWage;
        this.monthlyHours = other.monthlyHours;
    }

    /**
     * Constructs an HourlyEmployee with hourly wage of 20 and 
     * monthly hours of 160.
     */
    public HourlyEmployee(String aName, Date aHireDate) {
        this(aName, aHireDate, 20.00, 160.0);
        this.hourlyWage = 50.00;
    }

    public HourlyEmployee(String aName, Date aHireDate,
                          double anHourlyWage, double aMonthlyHours) {
        super(aName, aHireDate);
        disallowZeroesAndNegatives(anHourlyWage, aMonthlyHours);
        hourlyWage = anHourlyWage;
        monthlyHours = aMonthlyHours;
    }

    public double getHourlyWage() {
        return hourlyWage;
    }

    public void setHourlyWage(double newWage) {
        hourlyWage = newWage;
    }

    public double getMonthlyHours() {
        return monthlyHours;
    }

    public double monthlyPay() {
        return hourlyWage * monthlyHours;
    }

    public String toString() {
        return getName() + "; Hire Date: " + getHireDate() + "; Hourly Wage: "
            + hourlyWage + "; Monthly Hours: " + monthlyHours;
    }

    public static void main(String[] args) throws Exception {
        DateFormat df = DateFormat.getDateInstance();
        HourlyEmployee eva = new HourlyEmployee("Eva Luator",
                                                df.parse("June 10, 2013"));
        System.out.println("eva: " + eva);

        HourlyEmployee eva2 = new HourlyEmployee(eva.getName(),
                                                 eva.getHireDate());

        System.out.println("eva2: " + eva2);

        System.out.println("--------------------------------");

        eva.setHourlyWage(10000);
        System.out.println("eva: " + eva);
        System.out.println("eva2: " + eva2);
    }
}
