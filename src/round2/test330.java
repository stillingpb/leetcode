package round2;

public class test330 {
    public static void main(String[] args) {
        System.out.println(new test330().minPatches(new int[]{1,3}, 6));
        System.out.println(new test330().minPatches(new int[]{1,5,10}, 20));
        System.out.println(new test330().minPatches(new int[]{1,2,2}, 5));
    }

    public int minPatches(int[] nums, int n) {
        int added = 0, miss = 1, i = 0;
        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss) {
                miss += nums[i++];
            } else {
                miss <<= 1;
                added++;
            }
        }
        return added;
    }
}
