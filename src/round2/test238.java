package round2;

public class test238 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        new test238().productExceptSelf(nums);
        for (int i : nums)
            System.out.print(i + " ");
        System.out.println();

        nums = new int[]{0};
        new test238().productExceptSelf(nums);
        for (int i : nums)
            System.out.print(i + " ");
    }

    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }
        productExceptSelf(nums, 1, 0);
        return nums;
    }

    private int productExceptSelf(int[] nums, int preVal, int pos) {
        if (pos >= nums.length) {
            return 1;
        }
        int nextVal = productExceptSelf(nums, preVal * nums[pos], pos + 1);
        int cur = nums[pos];
        nums[pos] = preVal * nextVal;
        return nextVal * cur;
    }
}
