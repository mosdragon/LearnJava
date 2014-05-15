public class ArrTests {
    public static void main(String[] args) {
        double[] dubs = {4.5, 4.6, 4.7};
        for(double val: dubs) {
            System.out.println("The value is " + val);
        }
        int[][] grid = new int[2][];
        grid[0] = new int[2];
        grid[0][0] = 1;
        grid[0][1] = 2;
        grid[1] = new int[3];
        grid[1][0] = 10;
        grid[1][1] = 20;
        grid[1][2] = 30;

        for(int[] curr: grid) {
            for(int i: curr) {
                System.out.println("The val is: "+i);
            }
        }

        int[] incTester = new int[4];
        int index = 0;
        incTester[index++] = 14;

        for(int i : incTester) {
            System.out.println(i);
        }
    }
}