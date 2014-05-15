/**
 * A Student extends Comparable, so it can be sorted using
 * the sort function from the Set method. A student has a firstName,
 * lastName, and a grade.
 * @author Muhammad Osama Sakhi
 * @version 1.1
 */
public class Student implements Comparable<Student> {
    private String firstName;
    private String lastName;
    private double grade;

    /**
     * Constructor for a student. Takes in a first and last
     * name as parameters.
     * @param firstName, the Student's first name
     * @param lastName, the Student's last name
     */
    public Student(String firstName, String lastName) {
        if (!valid(firstName) || !valid(lastName)) {
            throw new IllegalArgumentException("Can't do that, grasshopper.");
        } else {
            this.firstName = firstName;
            this.lastName = lastName;
            grade = 0;
        }
    }
    /**
     * A private helper method to ensure that a name passed in the constructor
     * is not null, does not contain a space, and is not an empty string.
     * @param name, a name
     * @return true if the name is valid, false otherwise
     */
    private boolean valid(String name) {
        if (name == null) {
            return false;
        } else if (name.contains(" ") || name.isEmpty()) {
            return false;
        }
        return true;
    }
    /**
     * Sets the grade of the student to the double passed in as an argument
     * @param grade, the new grade to be set if it is greater than or equal to
     * zero.
     */
    public void setGrade(double grade) {
        if (grade >= 0 && grade <= 100) {
            this.grade = grade;
        }
    }
    /**
     * Returns a String representation of the Student object
     * @return the String representation of this Student
     */
    public String toString() {
        String blank = "%s %s: %.2f";
        String msg = String.format(blank, firstName, lastName, grade);
        return msg;
    }
    /**
     * Determines whether another Object equals this Student. They are equal
     * if and only if the other Object is not null, is an instance of Student,
     * and if the first and last name for both Students are equal.
     * @param other, another Object
     * @return true if the other object equals this Student, otherwise false
     */
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        } else if (!(other instanceof Student)) {
            return false;
        } else {
            Student that = (Student) other;
            boolean allSame = false;
            if (this.firstName.equals(that.firstName)
                && this.lastName.equals(that.lastName)) {
                allSame = true;
            }
            return allSame;
        }
    }
    /**
     * Compares the grade, firstName, and LastName of the other student o with
     * this student.
     * @param o, a Student object
     * @return the difference between two Student objects, useful for sorting
     */
    public int compareTo(Student o) {
        int diff = 0;
        diff += this.grade - o.grade;
        diff += this.firstName.compareTo(o.firstName);
        diff += this.lastName.compareTo(o.lastName);
        return diff;
    }
    /**
     * Creates a hashCode consistent with each use of the Student class using
     * the grade, firstName, and lastName of this Student.
     * @return a consistent hashCode
     */
    public int hashCode() {
        int result = 11;
        double temp = (new Double(grade)).hashCode();
        temp = (temp == 0) ? 11 : temp;
        result = 17 * result * ((int) temp);
        result = 17 * result * firstName.hashCode();
        result = 17 * result * lastName.hashCode();
        return result;
    }
}