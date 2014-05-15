import java.util.Random;
public class TrappedCandyMountain extends CandyMountain {
    private char[][] traps;
    private Random gen = new Random();
    public TrappedCandyMountain(int numTraps) {
        super();
        if (numTraps > 0) {
            traps = new char[8][8];
            int size = traps[0].length;
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    traps[i][j] = ' ';
                }
            }
            for (int i = 0; i < numTraps; i++) {
                int r = gen.nextInt(size);
                int c = gen.nextInt(size);
                Position test = new Position(r, c);
                Position zeros = new Position(0, 0);
                if (!(test.equals(goal)) && !(test.equals(liopleurodon))
                    && !(test.equals(zeros)) && traps[r][c] != '#') {
                    traps[r][c] = '#';
                } else {
                    --i;
                }
            }
        } else {
            traps = new char[1][1];
        }
    }
    @Override
    public int moveQuester(Move move) {
        int cost = super.moveQuester(move);
        int r = quester.getRow();
        int c = quester.getCol();
        if (traps[r][c] == '#') {
            cost = 999;
        }
        return cost;
    }
    @Override
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
                } else if (hasSeenLiopleurodon() && traps[i][j] == '#') {
                    map[i][j] = '#';
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
}