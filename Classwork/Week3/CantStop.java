
public class CantStop {
    public static void main(String[] args) {
        for (int z=0;z<10;z+=2) {
            System.out.printf("Hello, %d!%n",z+3);
        }
        for (String str : args) {
            System.out.println("Yo dawg, you "+str);
        }
        for (Whooshie s : Whooshie.values()) {
            System.out.printf("%s\t%s\t%s%n", s, s.getName(), s.getAge());
        }
    }
}