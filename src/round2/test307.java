package round2;

public class test307 {
    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{1, 2, 3});
        System.out.println(numArray.sumRange(0, 1));
        numArray.update(1, 10);
        System.out.println(numArray.sumRange(2, 2));
    }

    public static class NumArray {
        int[] nums;
        int[] sums;

        public NumArray(int[] nums) {
            this.nums = nums;
            sums = new int[nums.length];
            if (nums.length == 0) {
                return;
            }
            sums[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                sums[i] = sums[i - 1] + nums[i];
            }
        }

        void update(int i, int val) {
            int detal = val - nums[i];
            nums[i] = val;
            for (int j = i; j < sums.length; j++) {
                sums[j] += detal;
            }
        }

        public int sumRange(int i, int j) {
            if (i == 0) {
                return sums[j];
            } else {
                return sums[j] - sums[i - 1];
            }
        }

    }
}
