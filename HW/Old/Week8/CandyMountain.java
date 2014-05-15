import java.util.Random;
//import java.util.Arrays;
public class CandyMountain {
    public static final Move NORTH = new Move(-1, 0);
    public static final Move SOUTH = new Move(1, 0);
    public static final Move EAST = new Move(0, 1);
    public static final Move WEST = new Move(0, -1);
    protected int[][] grid;
    private Random gen = new Random();
    protected Position quester;
    protected Position goal;
    protected Position liopleurodon;
    protected boolean hasSeenLiopleurodon;
    protected boolean hasReachedGoal;
    protected boolean[][] beenThere;
    public CandyMountain() {
        this(8);
    }
    public CandyMountain(int size) {
        grid = new int[size][size];
        beenThere = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; i < size; i++) {
                beenThere[i][j] = false;
            }
        }
        beenThere[0][0] = true;
        int halfWay = size / 2;
        int firstHalf = gen.nextInt(halfWay);
        int secondHalf = gen.nextInt(halfWay) + halfWay;
        quester = new Position(0, 0);
        goal = new Position(secondHalf, secondHalf);
        liopleurodon = new Position(firstHalf, secondHalf);
        hasReachedGoal = false;
        hasSeenLiopleurodon = false;
    }
    public int moveQuester(Move move) {
        int cost;
        if (isValidMove(move)) {
            quester = quester.update(move);
            if (quester.equals(liopleurodon)) {
                hasSeenLiopleurodon = true;
            }
            if (hasSeenLiopleurodon && quester.equals(goal)) {
                hasReachedGoal = true;
            }
            int row = quester.getRow();
            int col = quester.getCol();
            beenThere[row][col] = true;
            cost = Math.abs(move.getRowDelta() + move.getColDelta());
        } else {
            cost = -1;
        }
        return cost;
    }
    private boolean isValidMove(Move move) {
        int max = grid[0].length;
        int currentRow = quester.getRow();
        int currentCol = quester.getCol();
        int addR = move.getRowDelta();
        int addC = move.getColDelta();
        boolean valid = true;
        if ((currentRow + addR) < 0 || (currentRow + addR) >= max) {
            valid = false;
        } else if ((currentCol + addC) < 0 || (currentCol + addC) >= max) {
            valid = false;
        }
        return valid;
    }
    public boolean hasReachedGoal() {
        return hasReachedGoal;
    }
    public boolean hasSeenLiopleurodon() {
        return hasSeenLiopleurodon;
    }
    public String toString() {
        int size = grid[0].length;
        char[][] map = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (hasSeenLiopleurodon && i == liopleurodon.getRow()
                    && j == liopleurodon.getCol()) {
                    map[i][j] = 'L';
                } else if (hasSeenLiopleurodon && i == goal.getRow()
                    && j == goal.getCol()) {
                    map[i][j] = 'G';
                } else if (i == quester.getRow() && j == quester.getCol()) {
                    map[i][j] = 'Q';
                } else if (hasSeenLiopleurodon && !quester.equals(liopleurodon)
                    && i == liopleurodon.getRow()
                    && j == liopleurodon.getCol()) {
                    map[i][j] = 'L';
                } else if (beenThere[i][j]) {
                    map[i][j] = '.';
                } else {
                    map[i][j] = ' ';
                }
            }
        }
        String line = "";
        String repeat = "+---";
        String msg;
        for (int j = 0; j < size; j++) {
            for (int i = 0; i < size; i++) {
                line += repeat;
            }
            line += "+\n";
            for (int k = 0; k < size; k++) {
                char point = map[j][k];
                msg = String.format("| %c ", point);
                line += msg;
            }
            line += "|\n";
        }
        for (int i = 0; i < size; i++) {
            line += repeat;
        }
        line += "+\n";
        return line;
    }
    // Unused
    /*
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (this == obj) {
            return true;
        } else if(!(obj instanceof CandyMountain)) {
            return false;
        }
        CandyMountain that = (CandyMountain) obj;
        boolean allSame = true;
        if (!quester.equals(that.quester)) {
            allSame = false;
        } else if (!goal.equals(that.goal)) {
            allSame = false;
        } else if (!liopleurodon.equals(that.liopleurodon)) {
            allSame = false;
        } else if (hasReachedGoal != that.hasReachedGoal) {
            allSame = false;
        } else if (hasSeenLiopleurodon != that.hasSeenLiopleurodon) {
            allSame = false;
        }
        return allSame;
    }
    private static boolean sameData(int[][] a, int[][] b) {
        //Will assume each row has same number of elements
        //Will assume each col has same number of elements
        boolean same = true;
        int aCol = a[0].length;
        int aRow = a.length;
        int bCol = b[0].length;
        int bRow = b.length;
        int maxR = Math.max(aRow, bRow);
        if (aCol == bCol && aRow == bRow) {
            //Determine elements here
            int count = 0;
            boolean notDone = true;
            boolean isSame = true;
            while (notDone) {
                int[] compA = a[count];
                int[] compB = b[count];
                isSame = Arrays.equals(compA, compB);
                count++;
                notDone =  (isSame && count < maxR);
            }
            same = isSame;
        } else {
            same = false;
        }
        return same;
    }
    */
    // Testing
    /*
    public static void main(String[] args) {
        CandyMountain mt = new CandyMountain();
        System.out.println(mt.hasSeenLiopleurodon());
        System.out.println(mt.hasReachedGoal());
        System.out.println(mt + "\n\n\n");
        mt.moveQuester(CandyMountain.EAST);
        System.out.println(mt + "\n\n\n");
        mt.moveQuester(CandyMountain.SOUTH);
        System.out.println(mt + "\n\n\n");
        mt.moveQuester(CandyMountain.SOUTH);
        System.out.println(mt + "\n\n\n");
        mt.moveQuester(CandyMountain.EAST);
        System.out.println(mt + "\n\n\n");
    }
    */
}