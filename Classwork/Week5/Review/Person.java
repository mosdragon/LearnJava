public class Person {

    private String firstName, lastName;

    public Person(String firstName, String lastName) {
        validate(firstName);
        validate(lastName);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        validate(firstName);
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        validate(lastName);
        this.lastName = lastName;
    }

    public void validate(String s) {
        if (s == null || s.equals("")) {
            System.exit(0);
        }
    }

    public String toString() {
        return "Person: " + firstName + " " + lastName;
    }

    private boolean contains(int[] arr, int num) {
        for (int i : arr)
            if (i == num) {
                return true;
            }
        }
        return false;
    }

}
