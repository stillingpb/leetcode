package round2;

public class test153 {
    public static void main(String[] args) {
        System.out.println(new test153().findMin(new int[]{1, 2, 3}));
        System.out.println(new test153().findMin(new int[]{2, 3, 1}));
        System.out.println(new test153().findMin(new int[]{3, 1, 2}));
    }

    public int findMin(int[] num) {
        int start = 0;
        int end = num.length - 1;
        while (start <= end) {
            int mid = (start + end) >>> 1;
            int val = num[mid];
            if (val < num[0])
                end = mid - 1;
            else
                start = mid + 1;
        }
        if (start < num.length)
            return num[start];
        else
            return num[0];
    }

}
