package round1;

public class Remove_Duplicates_from_Sorted_Array_II {

	public static void main(String[] args) {
		int[] a1 = { 1,1,1,2,2,3,3,3,4,4,5};
		Remove_Duplicates_from_Sorted_Array_II r = new Remove_Duplicates_from_Sorted_Array_II();
		int len = r.removeDuplicates(a1);
		System.out.println(len);
		for (int i = 0; i < len; i++)
			System.out.print(a1[i] + " ");
	}

	public int removeDuplicates(int[] A) {
		int cur = Integer.MAX_VALUE;
		int times = 1;
		int pos = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] != cur) {
				cur = A[i];
				times = 1;
			}
			if (times < 3)
				A[pos++] = A[i];
			times++;
		}
		return pos;
	}
}
