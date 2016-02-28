package round2;

import java.util.Arrays;

public class test274 {
    public static void main(String[] args) {
        System.out.println(new test274().hIndex(new int[]{3, 4, 4, 4, 4, 4}));
        System.out.println(new test274().hIndex(new int[]{0, 0}));
        System.out.println(new test274().hIndex(new int[]{3, 4, 5, 6, 7, 8}));
        System.out.println(new test274().hIndex(new int[]{1}));
        System.out.println(new test274().hIndex(new int[]{0, 1, 2, 3}));
    }

    public int hIndex(int[] citations) {
        int len = citations.length;
        int cnt[] = new int[len + 1];
        for (int c : citations) {
            if (c < len) {
                cnt[c]++;
            } else {
                cnt[len]++;
            }
        }
        for (int i = len, sum = 0; i > 0; i--) {
            sum += cnt[i];
            if (sum >= i) {
                return i;
            }
        }
        return 0;
    }

    public int hIndex2(int[] citations) {
        Arrays.sort(citations);
        int hindex = 0;
        for (int len = citations.length, i = len - 1; i >= 0; i--) {
            if (len - i <= citations[i])
                hindex = len - i;
            else
                break;
        }
        return hindex;
    }
}
