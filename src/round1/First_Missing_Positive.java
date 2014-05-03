package round1;

public class First_Missing_Positive {

	public static void main(String[] args) {
		First_Missing_Positive f = new First_Missing_Positive();
		System.out.println(f.firstMissingPositive2(new int[] { 3, 2, 2, 1 }));
	}

	public int firstMissingPositive2(int[] A) {
		int len = A.length;
		for (int i = 0; i < len; i++)
			if (A[i] <= 0)
				A[i] = len + 1;
		for (int i = 0; i < len; i++) {
			int temp = Math.abs(A[i]);
			if (temp <= len && A[temp - 1] > 0)
				A[temp - 1] = -A[temp - 1];
		}
		for (int i = 0; i < len; i++)
			if (A[i] > 0)
				return i + 1;
		return len + 1;
	}

	public int firstMissingPositive(int[] A) {
		boolean[] exist = new boolean[A.length];
		for (int i : A)
			if (i > 0 && i <= A.length)
				exist[i - 1] = true;
		for (int i = 0; i < exist.length; i++)
			if (!exist[i])
				return i + 1;
		return A.length + 1;
	}

}
