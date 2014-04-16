package round1;

import java.util.Arrays;

public class Sort_Colors {
	public static void main(String[] args) {
		Sort_Colors s = new Sort_Colors();
		int[] A = new int[] { 0, 1, 2, 0, 2, 1 };
		s.sortColors(A);
		for (int i : A)
			System.out.print(i + " ");
	}

	public void sortColors(int[] A) {
		int count0 = 0;
		int count1 = 0;
		for (int i : A) {
			if (i == 0)
				count0++;
			else if (i == 1)
				count1++;
		}
		Arrays.fill(A, 0, count0, 0);
		Arrays.fill(A, count0, count0 + count1, 1);
		Arrays.fill(A, count0 + count1, A.length, 2);
	}
}
