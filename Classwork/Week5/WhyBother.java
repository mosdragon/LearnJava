public class WhyBother {

    public static boolean inThere(int[] arr, int val) {
        boolean back = false;
        for (int i: arr) {
            if (i == val) {
                back = true;
            }
        }
        return back;
    }
    public static void main(String[] ninja) {
        long l = 128;
        byte i = 127;
        int[] hakuna = {1,2,3,4,5,6,20};
        int matata = 16;
        System.out.println(WhyBother.inThere(hakuna, matata));
    }
}