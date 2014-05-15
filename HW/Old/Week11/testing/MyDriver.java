import java.util.Random;
import java.util.ArrayList;

/**
 * Driver class to test Set
 * @author Son Tran
 * @version 1.0
 * Carl Sagan is awesome!
 */
public class MyDriver {
    private static Random rand = new Random();

    private static Set<Student> gradeBook = new Set<>(Student.class, 2);
    private static ArrayList<Student> studentList = new ArrayList<>(10);

    public static void main(String[] args) {
        fillStudentList();

        System.out.println("\nTest add(T entry) : --------------------------");
        System.out.println("Your result");
        System.out.println(gradeBook.add(studentList.get(0)));
        System.out.println(gradeBook.add(studentList.get(4)));
        System.out.println(gradeBook.add(studentList.get(5)));
        System.out.println(gradeBook.add(studentList.get(0)));
        System.out.println(gradeBook.add(studentList.get(3)));
        System.out.println(gradeBook.add(studentList.get(5)));
        System.out.println(gradeBook.add(studentList.get(9)));
        System.out.println("here, here\n\n" + gradeBook.add(new Student("Naveena", "Karusala")));
        //System.out.println(gradeBook.add(new Student("", "Karusal")) + "\n\n");
        System.out.println("\nExpect:");
        System.out.println("true");
        System.out.println("true");
        System.out.println("true");
        System.out.println("false");
        System.out.println("true");
        System.out.println("false");
        System.out.println("true");

        System.out.println("\nTest remove(Object entry) : ------------------");
        addStudent();
        System.out.println("Your result");
        System.out.println(gradeBook.remove(studentList.get(0)));
        System.out.println(gradeBook.remove(studentList.get(9)));
        System.out.println(gradeBook.remove(studentList.get(3)));
        System.out.println(gradeBook.remove(studentList.get(4)));
        System.out.println(gradeBook.remove(studentList.get(6)));
        System.out.println(gradeBook.remove(studentList.get(5)));
        System.out.println(gradeBook.remove(studentList.get(5)));
        
        System.out.println("\nExpect:");
        System.out.println(studentList.get(0));
        System.out.println(studentList.get(9));
        System.out.println(studentList.get(3));
        System.out.println(studentList.get(4));
        System.out.println("null");
        System.out.println(studentList.get(5));
        System.out.println("null");
        // for (Student s : studentList) {
        //     System.out.println(s);
        // }

        System.out.println("\nTest remove(int index) : ---------------------");
        addStudent();
        System.out.println("Your result");
        System.out.println(gradeBook.remove(0));
        System.out.println(gradeBook.remove(5));
        System.out.println(gradeBook.remove(3));
        System.out.println(gradeBook.remove(6));
        System.out.println(gradeBook.remove(1));
        System.out.println(gradeBook.remove(2));
        System.out.println(gradeBook.remove(4));
        System.out.println(gradeBook.remove(1));
        System.out.println(gradeBook.remove(0));
        System.out.println(gradeBook.remove(0));
        System.out.println("\nExpect:");
        System.out.println(studentList.get(0));
        System.out.println(studentList.get(9));
        System.out.println(studentList.get(4));
        System.out.println("null");
        System.out.println(studentList.get(7));
        System.out.println(studentList.get(5));
        System.out.println("null");
        System.out.println(studentList.get(2));
        System.out.println(studentList.get(3));
        System.out.println("null");

        System.out.println("\nTest contains(T entry) : ---------------------");
        addStudent();
        System.out.println("Your result");
        System.out.println(gradeBook.contains(new Student("Carl0", "Sagan0")));
        System.out.println(gradeBook.contains(new Student("Carl5", "Sagan5")));
        System.out.println(gradeBook.contains(new Student("Carl7", "Sagan7")));
        System.out.println(gradeBook.contains(new Student("Carl3", "Sagan3")));
        System.out.println(gradeBook.contains(new Student("Carl6", "Sagan6")));
        System.out.println(gradeBook.contains(new Student("Carl5", "Sagan7")));
        System.out.println(gradeBook.contains(new Student("Carl7", "Sagan5")));
        System.out.println(gradeBook.contains(new Student("Carl9", "Sagan9")));
        System.out.println(gradeBook.contains(new Student("CarlX", "SaganX")));
        System.out.println("\nExpect:");
        System.out.println("true");
        System.out.println("true");
        System.out.println("true");
        System.out.println("true");
        System.out.println("false");
        System.out.println("false");
        System.out.println("false");
        System.out.println("true");
        System.out.println("false");

        System.out.println("\nTest toArray() : -----------------------------");
        addStudent();
        Student[] studentArray = gradeBook.toArray();
        System.out.println("Your result:");
        printArray(studentArray);
        System.out.println("\nExpect:");
        System.out.println(studentList.get(0));
        System.out.println(studentList.get(3));
        System.out.println(studentList.get(7));
        System.out.println(studentList.get(2));
        System.out.println(studentList.get(4));
        System.out.println(studentList.get(5));
        System.out.println(studentList.get(9));

        System.out.println("\nTest toString() : ----------------------------");
        addStudent();
        System.out.println("Your result:");
        System.out.println(gradeBook);
        System.out.println("Expect:");
        System.out.println("The gradebook:");
        System.out.println(studentList.get(0));
        System.out.println(studentList.get(3));
        System.out.println(studentList.get(7));
        System.out.println(studentList.get(2));
        System.out.println(studentList.get(4));
        System.out.println(studentList.get(5));
        System.out.println(studentList.get(9));

        System.out.println("\nTest sort() : --------------------------------");
        addStudent();
        studentArray = gradeBook.sort();
        printArray(studentArray);
        System.out.println("-------------------------------------------------\n"
            + "Tee hee\n\n" + gradeBook);

        gradeBook.clear();
        System.out.println("\nIs it empty? " + gradeBook.isEmpty());
        addStudent();
        System.out.println("\nIs it empty? " + gradeBook.isEmpty());

        Set<Student> gbook1 = new Set<>(Student.class, 0);
        System.out.println(gbook1.add(studentList.get(0)));
        System.out.println(gbook1.add(studentList.get(4)));
        System.out.println(gbook1.add(studentList.get(5)));
        System.out.println(gbook1.add(studentList.get(5)));
        System.out.println(gbook1.size());
        System.out.println(gbook1.contains(studentList.get(5)));
        gbook1.clear();
        System.out.println(gbook1.size());
        System.out.println("\n\n\n\n\n");

        Student fool1 = new Student("Osama", "As");
        System.out.println(fool1);
        fool1.setGrade(22f);
        System.out.println(fool1);
        Student fool2 = new Student("Yee-___-haw", "Sa");
        System.out.println(fool2);
        System.out.println(fool1.hashCode());
        System.out.println(fool2.hashCode());

        gbook1.clear();
        Student fool3 = new Student("Big", "Boy");
        Student fool4 = new Student("big", "Boy");
        System.out.println(gbook1.add(fool3));
        System.out.println(gbook1.add(fool4));
        System.out.println(gbook1);
        System.out.println("\n\n" + printArray(gbook1.sort()));

    }

    private static void addStudent() {
        gradeBook.clear();
        gradeBook.add(studentList.get(0));
        gradeBook.add(studentList.get(3));
        gradeBook.add(studentList.get(7));
        gradeBook.add(studentList.get(2));
        gradeBook.add(studentList.get(4));
        gradeBook.add(studentList.get(5));
        gradeBook.add(studentList.get(9));
    }

    private static void fillStudentList() {
        for (int i = 0; i < 10; i++) {
            Student a = new Student("Carl" + i, "Sagan" + i);
            a.setGrade(rand.nextInt(100));
            studentList.add(a);
        }
    }

    private static void printArray(Student[] studentArray) {
        for (int i = 0; i < studentArray.length; i++) {
            if (studentArray[i] != null) {
                System.out.println(studentArray[i]);
            }
        }
    }
}
