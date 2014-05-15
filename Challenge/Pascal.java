public class Pascal {
    public static int fac(int n) {
        if (n < 0) {
            return -1;
        } else if (n == 0) {
            return 1;
        }
        int product = 1;
        for (int i = n; i > 0; i--) {
            product *= i;
        }
        return product;
    }

    public static int combination(int a, int b) {
        if (a < b) {
            return 0;
        }
        int c = a - b;
        return fac(a)/(fac(b) * fac(c));
    }

    public static void printPascal(int n) {
        for (int j = 0; j <= n; j++) {
            System.out.print(combination(n, j) + "\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println(fac(4));
        System.out.println(combination(4,2));
        System.out.println(combination(4,1));
        for (int i = 0; i < 10; i++) {
            printPascal(i);
        }
        // printPascal(3);
    }
}