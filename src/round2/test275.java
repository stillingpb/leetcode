package round2;

import java.util.Arrays;

public class test275 {
    public static void main(String[] args) {
        System.out.println(new test275().hIndex(new int[]{3, 4, 4, 4, 4, 4}));
        System.out.println(new test275().hIndex(new int[]{0, 0}));
        System.out.println(new test275().hIndex(new int[]{3, 4, 5, 6, 7, 8}));
        System.out.println(new test275().hIndex(new int[]{1}));
        System.out.println(new test275().hIndex(new int[]{0, 1, 2, 3}));

    }

    public int hIndex(int[] citations) {
        int len = citations.length;
        int low = 0, high = len - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (len - mid < citations[mid]) {
                high = mid - 1;
            } else if (len - mid > citations[mid]) {
                low = mid + 1;
            } else {
                return len - mid;
            }
        }
        return len - low;
    }
}
