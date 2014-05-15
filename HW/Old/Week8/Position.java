public class Position {
    private int row;
    private int col;
    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }
    public int getRow() {
        return row;
    }
    public int getCol() {
        return col;
    }
    public Position update(Move move) {
        int nRow = row + move.getRowDelta();
        int nCol = col + move.getColDelta();
        return new Position(nRow, nCol);
    }
    public String toString() {
        return String.format("Row: %d\tColumn: %d", row, col);
    }
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        } else if (this == other) {
            return true;
        } else if (!(other instanceof Position)) {
            return false;
        }
        Position that = (Position) other;
        boolean allSame = true;
        if (this.row != that.row || this.col != that.col) {
            allSame = false;
        }
        return allSame;
    }
    public int hashCode() {
        return super.hashCode();
    }
    // Testing
    /*
    public static void main(String[] args) {
        Position origin = new Position(0,0);
        origin = origin.update(new Move(2,2));
        System.out.println(origin.getCol());
        System.out.println(origin.getRow());
        Position diff = new Position(2,2);
        Position copy = origin;
        Object obj = new Position(2,2);
        System.out.println(origin.equals(diff));
        System.out.println(origin.equals(copy));
        System.out.println(origin.equals(obj));
    }
    */
}