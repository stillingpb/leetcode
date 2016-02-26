package round2;

public class test260 {
    public static void main(String[] args) {
        int[] ans = new test260().singleNumber(new int[]{1, 2, 1, 3, 2, 5});
        System.out.println(ans[0] + " " + ans[1]);
    }

    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int nb : nums) {
            xor ^= nb;
        }
        int lowBit = xor & -xor;
        int a = 0, b = 0;
        for (int nb : nums) {
            if ((nb & lowBit) != 0) {
                a ^= nb;
            } else {
                b ^= nb;
            }
        }
        return new int[]{a, b};
    }
}
