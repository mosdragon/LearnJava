public class Searching {
    public static int binarySearch(int[] sorted, int val) {
        if (sorted.length == 1 && sorted[0] == val) {
            return 0;
        } else if (sorted.length == 1 && sorted[0] != val) {
            return -1;
        }
        int mid = (int) (Math.ceil(sorted.length/2.0));
        System.out.println(mid);
        if (sorted[mid - 1] == val) {
            return mid;
        } else if (val > sorted[mid - 1]) {
            int size = mid;
            if (sorted.length % 2 == 1) {
                size = mid - 1;
            }
            int[] temp = new int[size];
            for (int i = 0; i < size; i++) {
                temp[i] = sorted[size + i];
            }
            print(temp);
            return mid + binarySearch(temp, val);
        } else if (val < sorted[mid - 1]) {
            int size = mid;
            // if (sorted.length % 2 = 1) {
            //     size = mid - 1;
            // }
            int[] temp = new int[size];
            for (int i = 0; i < size; i++) {
                temp[i] = sorted[size + i];
            }
            print(temp);
            return binarySearch(temp, val);
        }
        return -1;
    }
    public static void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr = {0,100,200,300,400,500,600,700,800,900,1000};
        System.out.println(binarySearch(arr, 300));
    }
}