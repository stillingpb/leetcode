package round1;

public class Maximum_Subarray {

	public static void main(String[] args) {
		int[] A = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		Maximum_Subarray m = new Maximum_Subarray();
		System.out.println(m.maxSubArray(A));
	}

	public int maxSubArray(int[] A) {
		int max = Integer.MIN_VALUE;
		int cur = -1;
		for (int i = 0; i < A.length; i++) {
			cur = cur <= 0 ? A[i] : A[i] + cur;
			max = Math.max(max, cur);
		}
		return max;
	}
}
