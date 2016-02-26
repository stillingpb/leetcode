package round2;

public class test268 {
    public static void main(String[] args) {
        System.out.println(new test268().missingNumber(new int[]{3, 1, 0}));
    }

    public int missingNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i && nums[i] < nums.length && nums[i] >= 0) {
                int j = nums[i];
                nums[i] = nums[j];
                nums[j] = j;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i]) {
                return i;
            }
        }
        return nums.length;
    }
}
