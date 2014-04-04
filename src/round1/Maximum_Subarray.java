package round1;

public class Maximum_Subarray {
	public static void main(String[] args) {
		int A[] = new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		int ret = new Maximum_Subarray().maxSubArray(A);
		System.out.println(ret);
	}

	public int maxSubArray(int[] A) {
		int ret = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = 0; i < A.length; i++) {
			sum = Math.max(sum + A[i], A[i]);
			ret = Math.max(sum, ret);
		}
		return ret;
	}

}
