import java.util.Random;

public class CardGame {

    private int[][] grid1;
    private int[][] grid2;
    private boolean[] placed;
    private Random gen;
    public CardGame() {
        grid1 = new int[4][4];
        grid2 = new int[4][4];
        placed = new boolean[16];
        int count = 0;
        for (int i = 0; i < grid1.length; i++) {
            for (int j = 0; j < grid1[i].length; j++) {
                grid1[i][j] = ++count;
            }
        }
        gen = new Random();
        boolean same = gen.nextBoolean();
        // If same==true, grid2 will also run straight from
        // 1 to 16, just like grid1
        if (same) {
            count = 0;
            for (int i = 0; i < grid2.length; i++) {
                for (int j = 0; j < grid2[i].length; j++) {
                    grid2[i][j] = ++count;
                }
            }
        // If same==false, grid2 will get random numbers placed
        // in its grid.      
        } else {
            int value;
            int row = 0;
            int col = 0;
            boolean notFull = true;
            while(!allTrue() && notFull) {
                value = gen.nextInt(16) + 1;
                if (!placed[value - 1]) {
                    placed[value - 1] = true;
                    grid2[row][col] = value;
                    col++;
                }
                // When the col size exceeds the length of columns, the row
                // count increments.
                if (col >= grid2[row].length) {
                    //System.out.println("Col is now: " + col);
                    col = 0;
                    row++;
                }
                // If row exceeds the possible length of rows, the value
                // notFull will be true, thus stopping the while loop
                if (row >= grid2.length) {
                    //System.out.println("Row is now: " + row);
                    notFull = false;
                }
            }
        }
    }
    private boolean allTrue() {
        for (boolean b : placed) {
            if (!b) {
                return b;
            }
        }
        return true;
    }
    public void printGrids() {
        System.out.println("Grid 1:");
        for (int[] row : grid1) {
            for (int x : row) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
        System.out.println("\n\nGrid 2:");
        for (int[] row : grid2) {
            for (int x : row) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
    public void printG1() {
        for (int[] row : grid1) {
            for (int x : row) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
    public void printG2() {
        for (int[] row : grid2) {
            for (int x : row) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        CardGame cg = new CardGame();
        cg.printGrids();
        cg.printG1();
        cg.printG2();
    }
}