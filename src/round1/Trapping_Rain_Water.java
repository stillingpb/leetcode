package round1;

public class Trapping_Rain_Water {

	public static void main(String[] args) {
		int[] A = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		Trapping_Rain_Water t = new Trapping_Rain_Water();
		System.out.println(t.trap(A));
	}

	public int trap(int[] A) {
		if(A.length == 0)
			return 0;
		int maxIndex = 0;
		for (int i = 1; i < A.length; i++)
			if (A[maxIndex] < A[i])
				maxIndex = i;
		int water = 0;
		int height = A[0];
		for (int i = 1; i < maxIndex; i++) {
			if (height < A[i])
				height = A[i];
			else
				water += height - A[i];
		}
		height = A[A.length - 1];
		for (int i = A.length - 2; i > maxIndex; i--) {
			if (height < A[i])
				height = A[i];
			else
				water += height - A[i];
		}
		return water;
	}
}
