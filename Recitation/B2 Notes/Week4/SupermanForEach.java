public class SupermanForEach {
    public static void main(String[] args) {
        // Create a team of supermen
        Superman[] mySuperTeam = {new Superman(), new Superman("Kevin"), new Superman("Peter", 25)};

        // Loop through the team and print out their name, age, and favorite food
        System.out.println("Use index to loop");
        for (int i = 0; i < mySuperTeam.length; i++) {
            System.out.printf("Superman %s is %d and ", mySuperTeam[i].getName(), mySuperTeam[i].getAge());
            mySuperTeam[i].printFavFood();
        }

        // We can write a more elegant loop using for each
        System.out.println("Use for each to loop");
        for (Superman s: mySuperTeam) {
            System.out.printf("Superman %s is %d and ", s.getName(), s.getAge());
            s.printFavFood();
        }
    }
}