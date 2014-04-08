package round1;

public class Remove_Duplicates_from_Sorted_Array {

	public static void main(String[] args) {
		Remove_Duplicates_from_Sorted_Array r = new Remove_Duplicates_from_Sorted_Array();
		int[] A = new int[] { 1, 1, 2, 2, 2, 3 };
		int ans = r.removeDuplicates(A);
		for (int i = 0; i < ans; i++)
			System.out.print(A[i]);
	}

	public int removeDuplicates(int[] A) {
		if (A.length == 0)
			return 0;
		int cur = A[0];
		int curIndex = 0;
		for (int i = 1; i < A.length; i++) {
			if (cur != A[i]) {
				cur = A[i];
				A[++curIndex] = A[i];
			}
		}
		return curIndex + 1;
	}
}
