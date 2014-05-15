import java.util.Scanner;

public class CharliesQuest {

    public static void main(String[] args) throws Exception {
        CandyMountain world;
        int initialHealth = (args.length > 0) ? Integer.parseInt(args[0]) : 10;
        world = (args.length > 1)
            ? new TrappedCandyMountain(Integer.parseInt(args[1]))
            : new CandyMountain();
        Quester quester = new Quester("Charlie", initialHealth);
        Scanner keyboard = new Scanner(System.in);
        boolean gameOver = false;
        do {
            System.out.println(world);
            System.out.println(quester.getName() + "'s health: "
                               + quester.getHealth());
            System.out.println("Enter N, S, E, or W to move "
                               + quester.getName());
            String input = keyboard.nextLine().toUpperCase();
            Move move = CandyMountain.SOUTH;
            if (input.equals("N")) { move = CandyMountain.NORTH; }
            if (input.equals("E")) { move = CandyMountain.EAST; }
            if (input.equals("W")) { move = CandyMountain.WEST; }
            if (input.equals("S")) { move = CandyMountain.SOUTH; }
            int cost = world.moveQuester(move);
            if (cost == -1) {
                System.out.println("Invalid move: " + input);
            } else {
                quester.updateHealth(-cost);
            }
            if (world.hasSeenLiopleurodon()) {
                System.out.println("The liopleurodon has spoken! "
                                   + "Candy Mountain is nigh!");
            }
            gameOver = !quester.isAlive() || world.hasReachedGoal();
        } while (!gameOver);
        if (quester.isAlive()) {
            System.out.println("You found Candy Mountain!  Good bye, "
                               + quester.getName() + "!");
        } else {
            System.out.println("You passed out and they took your "
                               + "freakin' kidney!");
        }
    }
}
