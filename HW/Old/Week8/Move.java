public class Move {
    private String name;
    private int rowDelta;
    private int colDelta;
    public Move(String name, int rowDelta, int colDelta) {
        this.name = name;
        this.rowDelta = rowDelta;
        this.colDelta = colDelta;
    }
    public Move(int rowDelta, int colDelta) {
        this(String.format("Move (%d,%d)", rowDelta, colDelta), rowDelta,
            colDelta);
    }
    public int getRowDelta() {
        return rowDelta;
    }
    public int getColDelta() {
        return colDelta;
    }
    public String toString() {
        return name;
    }
    // Testing
    /*
    public static void main(String[] args) {
        Move m1 = new Move(2,2);
        System.out.println(m1);
        System.out.println(m1.getColDelta());
        System.out.println(m1.getRowDelta());
        m1 = new Move("DONE", -1,0);
        System.out.println(m1);
        System.out.println(m1.getColDelta());
        System.out.println(m1.getRowDelta());
    }
    */
}