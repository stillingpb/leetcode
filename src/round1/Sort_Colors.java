package round1;

public class Sort_Colors {

	public static void main(String[] args) {
		Sort_Colors s = new Sort_Colors();
		int[] A = new int[] { 0, 1, 2, 0, 1, 2, 0, 1, 2 };
		s.sortColors(A);
		for (int i : A)
			System.out.print(i + " ");
	}

	public void sortColors(int[] A) {
		int pos0 = 0;
		int pos2 = A.length - 1;
		int pi = 0;
		while (pi <= pos2) {
			if (A[pi] == 0)
				A[pos0++] = 0;
			else if (A[pi] == 2) {
				while (pi <= pos2 && A[pos2] == 2)
					pos2--;
				if (pi >= pos2)
					break;
				if (A[pos2] == 0)
					A[pi--] = 0;
				A[pos2--] = 2;
			}
			pi++;
		}
		for (pi = pos0; pi <= pos2; pi++)
			A[pi] = 1;
	}
}