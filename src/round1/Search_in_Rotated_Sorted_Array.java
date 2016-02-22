package round1;

public class Search_in_Rotated_Sorted_Array {

    public static void main(String[] args) {
        Search_in_Rotated_Sorted_Array s = new Search_in_Rotated_Sorted_Array();
        System.out.println(s.search(new int[]{1, 2, 3}, 1));
        System.out.println(s.search(new int[]{2, 3, 1}, 1));
        System.out.println(s.search(new int[]{3, 1, 2}, 1));
    }

    public int search(int[] A, int target) {
        if (A == null || A.length == 0)
            return -1;
        int low = 0;
        int high = A.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (target == A[mid])
                return mid;
            if (A[mid] < A[high]) {
                if (A[mid] < target && target <= A[high])
                    low = mid + 1;
                else
                    high = mid - 1;
            } else {
                if (A[low] <= target && target < A[mid])
                    high = mid - 1;
                else
                    low = mid + 1;
            }
        }
        return -1;
    }
}
