package round1;

public class Median_of_Two_Sorted_Arrays {
	public static void main(String[] args) {
		int[] B = { 0,1 };
		int[] A = { 2, 3 };
		Median_of_Two_Sorted_Arrays m = new Median_of_Two_Sorted_Arrays();
		System.out.println(m.findMedianSortedArrays(A, B));
	}

	public double findMedianSortedArrays(int A[], int B[]) {
		int mid = (A.length + B.length - 1) / 2;
		int ai = 0;
		int bi = 0;
		int i = 0;
		double midVal = 0;
		while (ai < A.length && bi < B.length && i <= mid) {
			if (A[ai] < B[bi]) {
				if (i == mid)
					midVal = A[ai];
				ai++;
			} else {
				if (i == mid)
					midVal = B[bi];
				bi++;
			}
			i++;
		}
		while (i <= mid && ai < A.length) {
			if (i == mid)
				midVal = A[ai];
			i++;
			ai++;
		}
		while (i <= mid && bi < B.length) {
			if (i == mid)
				midVal = B[bi];
			i++;
			bi++;
		}
		if ((A.length + B.length) % 2 == 0) {
			if (ai < A.length && bi < B.length)
				midVal = 1.0 * (midVal + Math.min(A[ai], B[bi])) / 2;
			else if (ai < A.length)
				midVal = 1.0 * (midVal + A[ai]) / 2;
			else
				midVal = 1.0 * (midVal + B[bi]) / 2;
		}
		return midVal;
	}
}
