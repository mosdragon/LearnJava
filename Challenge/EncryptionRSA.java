import java.util.HashMap;

public class EncryptionRSA {
    private int p;
    private int q;
    private int n;
    private int phiN;
    private int d;
    private int e;

    public EncryptionRSA(int p, int q, int e) {
        this.p = p;
        this.q = q;
        n = p * q;
        this.e = e;
        phiN = (p - 1) * (q - 1);
        // int[] invMod = inverseMod(e, phiN);
        // d = invMod[0];
        d = 1;
        System.out.printf("p: %d%nq: %d%nn: %d%nphiN: %d%n", p, q, n, phiN);
        System.out.printf("e: %d%nd: %d%n", e, d);
    }

    private static class Combination {
        public HashMap<int[], int[]> vals;
        
        public Combination() {
            vals = new HashMap<>();
        }
        // The first int[] shall store a,b - the numbers for which the gcd will be obtained
        // The second will store c and d such that a = c*b + d
        public void addToMap(int a, int b) {
            if (b != 0) {
                int c = a / b;
                int d = a % b;
                System.out.printf("a:%d b:%d c:%d d:%d%n", a, b, c, d);
                vals.put(new int[] {a, b}, new int[] {c, d});
                System.out.println("Test Run:" + b + "\t" + d + "\n");
                this.addToMap(b, d);
            }

            // if (c > 1) {
            //     c = gcd(b, c);
            // }
            // return c;
        }
    }


    // Where a is the larger number, b is the small number
    // private int gcd(int a, int b) {
    //     int c = -(a - 1)/b;
    //     c = c % a;
    //     return c;
    // i

    // private int gcd(int a, int b) {
    //     int c = (a - 1) / b;
    //     c = mod(c, a);
    //     return c;
    // }

    /*private static int gcd(int a, int b) {
        int c = a % b;
        if (c > 1) {
            c = gcd(b, c);
        }
        return c;
    }

    private static int[] inverseMod(int p, int q) {
        if (q == 0) {
            return new int[] { p, 1, 0 };    
        }

      int[] vals = inverseMod(q, p % q);
      int d = vals[0];
      int a = vals[2];
      int b = vals[1] - (p / q) * vals[2];
      return new int[] { d, a, b };
    }*/

    // public int invmod(int dividend, int divisor) {
    //     int min = gcd(dividend, divisor);
    //     int val = dividend % divisor;
    //     if (val < 0) {
    //         val += divisor;
    //     }
    //     return val;
    // }

    // public int invmod(int dividend, int divisor) {
    //     int val = dividend % divisor;
    //     if (val < 0) {
    //         val += divisor;
    //     }
    //     return val;
    // }

    // public String encrypt(String str) {
    //     char[] letters = new char[str.length()];
    //     for (int i = 0; i < str.length(); i++) {
    //         int c = (int) str.charAt(i);
    //         c = (c ^ e) % n;
    //         letters[i] = (char) c;
    //     }
    //     String combined = new String(letters);
    //     return combined;
    // }

    // public String decrypt(String str) {
    //     char[] letters = new char[str.length()];
    //     for (int i = 0; i < str.length(); i++) {
    //         int c = (int) str.charAt(i);
    //         c = (c ^ d) % n;
    //         letters[i] = (char) c;
    //     }
    //     String combined = new String(letters);
    //     return combined;
    // }

    public String encrypt(String str) {
        char[] letters = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            int c = (int) str.charAt(i);
            c = (c ^ e) % n;
            letters[i] = (char) c;
        }
        String combined = new String(letters);
        return combined;
    }

    public String decrypt(String str) {
        char[] letters = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            int c = (int) str.charAt(i);
            c = (c ^ d) % n;
            letters[i] = (char) c;
        }
        String combined = new String(letters);
        return combined;
    }

    public static void main(String[] args) {
        EncryptionRSA rsa = new EncryptionRSA(43, 59, 13);

        String str = "My name";
        String cipherText = rsa.encrypt(str);
        String messageText = rsa.decrypt(cipherText);

        System.out.println(str);
        System.out.println(cipherText);
        System.out.println(messageText);
        System.out.println("\n\n" + -5 % 5 + "\n\n");

        System.out.println("Trying a mapping:\n");
        Combination abc = new Combination();
        abc.addToMap(2436, 13);
        HashMap<int[], int[]> map = abc.vals;
        System.out.println();
        for(int[] a : map.keySet()) {
            int[] val = map.get(a);
            System.out.print(a[0] + "\t" + a[1]);
            System.out.println("\t\t" + val[0] + "\t" + val[1]);
        }
    }

}