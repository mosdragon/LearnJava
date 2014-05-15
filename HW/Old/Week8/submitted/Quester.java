public class Quester {
    private String name;
    private int health;
    public Quester(String name, int startingHealth) {
        this.name = name;
        health = startingHealth;
    }
    public String getName() {
        return name;
    }
    public int getHealth() {
        return health;
    }
    public void updateHealth(int n) {
        health += n;
    }
    public boolean isAlive() {
        return (health > 0);
    }
    //Testing
    /*
    public static void main(String[] args) {
        Quester me = new Quester("me", 110);
        System.out.println(me.getName());
        System.out.println(me.getHealth());
        me.updateHealth(-110);
        System.out.println(me.getHealth());
        System.out.println(me.isAlive());
    }
    */
}