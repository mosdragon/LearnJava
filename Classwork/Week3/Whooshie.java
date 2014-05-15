public enum Whooshie {

    us("me", 15),
    they("they", 25),
    dummy("yahh", 9000);

    private final String name;
    private final int age;

   Whooshie(String str, int n) {
        name = str;
        age = n;
    }

    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
   /* public String toString() {
        String str = new String();
        str = String.format("My name is %s and I am %d years old", name, age);
        return str;
    }*/
}