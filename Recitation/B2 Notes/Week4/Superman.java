public class Superman {
    private String name;
    private int age;

    // I make this variable public to show you
    // why we should not make any variables of a class
    // public unless you really have to 
    public String hometown = "Metropolis";

    //
    public Superman(String name, int age) {
        this.name = name;
        this.age = age;
        // IMPORTANT: if you write name = name
        // then the name of your superman doesn't change. Because
        // name = name only says that you assign the input to itself
        // If your input is newName, then you can write name = newName
        // On the test, we may trick you with question like this 
    }

    // General constructor
    public Superman() {
        this("Clark", 35);
        // This line of code will call the constructor above
        // and pass in Clark and 35 as name and age.
        // This is good coding style
        // This constructor tells that the superman you
        // create will be Clark and 35 years old. 
    }

    public Superman(String name) {
        this(name, 35);
        // This constructor tells that the superman will be
        // 35 and have whatever name you give him
    }

    // Getter method that returns age
    public int getAge() {
        return age;
    }

    // Getter method that returns name
    public String getName() {
        return name;
    }

    // Setter method to change name
    public void setName(String newName) {
        name = newName;
        // If the input is name, then you cannot
        // write name = name
    }

    // Setter method to change age
    public void setAge(int newAge) {
        age = newAge;
    }

    // A method that print out the superman favorite food
    public void printFavFood() {
        System.out.println("My favorite food is dumpling.");
    }
} 