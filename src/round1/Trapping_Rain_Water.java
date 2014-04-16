package round1;

import java.util.Stack;

public class Trapping_Rain_Water {

	public static void main(String[] args) {
		int[] A = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

		int count = new Trapping_Rain_Water().trap(A);
		System.out.println(count);
	}

	public int trap(int[] A) {
		if(A.length == 0)
			return 0;
		int count = 0;
		int maxIndex = 0;
		for (int i = 1; i < A.length; i++)
			if (A[maxIndex] < A[i])
				maxIndex = i;
		int height = A[0];
		for (int i = 1; i <= maxIndex; i++) {
			if (height < A[i])
				height = A[i];
			else
				count += height - A[i];
		}
		height = A[A.length - 1];
		for (int i = A.length - 2; i >= maxIndex; i--) {
			if (height < A[i])
				height = A[i];
			else
				count += height - A[i];
		}
		return count;
	}
}
