package round1;

public class Remove_Duplicates_from_Sorted_Array_II {

	public static void main(String[] args) {
		Remove_Duplicates_from_Sorted_Array_II r = new Remove_Duplicates_from_Sorted_Array_II();
		int[] A = new int[] { 1, 1, 1, 1,2, 3, 3 ,4};
		int ans = r.removeDuplicates(A);
		for (int i = 0; i < ans; i++)
			System.out.print(A[i]);
	}

	public int removeDuplicates(int[] A) {
		if (A.length == 0)
			return 0;
		int times = 1;
		int curIndex = 0;
		for (int i = 1; i < A.length; i++) {
			if (A[curIndex] == A[i]) {
				times++;
				if (times <= 2) {
					A[++curIndex] = A[i];
				}
			} else {
				times = 1;
				A[++curIndex] = A[i];
			}
		}
		return curIndex + 1;
	}
}
