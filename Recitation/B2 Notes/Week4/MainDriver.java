public class MainDriver {
    public static void main(String[] args) {
        System.out.println("The program is running.");
        Superman super1 = new Superman();
        System.out.printf("super1 is %s and he is %d.\n", super1.getName(), super1.getAge());
        Superman super2 = new Superman("Carl Sagan");
        System.out.printf("super2 is %s and he is %d.\n", super2.getName(), super2.getAge());
        Superman super3 = new Superman("Brian Greene", 50);
        System.out.printf("super3 is %s and he is %d.\n", super3.getName(), super3.getAge());

        System.out.println("Let's change super1's name to Isaac Newton");
        super1.setName("Isaac Newton");
        System.out.printf("super1 is %s and he is %d.\n", super1.getName(), super1.getAge());
        System.out.println("Let's change super2's age to 45");
        super2.setAge(45);
        System.out.printf("super2 is %s and he is %d.\n", super2.getName(), super2.getAge());
        System.out.println("Let's change super3's age and name");
        super3.setName("Robert Oppenheimer");
        super3.setAge(65);
        System.out.printf("super3 is %s and he is %d.\n", super3.getName(), super3.getAge());

        System.out.println("\nNow is why we should not make a class' variable public");
        // Without the getter method for hometown, we can gain access to the hometown
        // directly. No need for the getter method bozo.
        System.out.printf("Hometown of super1 is: %s.\n", super1.hometown);

        // However, direct access also means I can change the hometown of your superman
        // at will.
        System.out.println("Let's make superman hometown Atlanta.");
        super1.hometown = "Atlanta";
        System.out.printf("Hometown of super1 is: %s.\n", super1.hometown);
        System.out.println("Other supermen's hometown is still Metropolis.");
        System.out.printf("Hometown of super2 is: %s.\n", super2.hometown);
        System.out.printf("Hometown of super3 is: %s.\n", super3.hometown);

        // If you don't want the user to change the hometown of your
        // beloved superman to a town in the middle of nowhere, don't make
        // that variable public

        // Last note: a private variable of a class CANNOT be changed unless
        // you create a setter method to change it. Also it CANNOT be accessed
        // unless you create a getter method to retrieve it.

        System.out.println("Let's make super1 do some actions");
        super1.printFavFood();
    }
}