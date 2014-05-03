package round1;

public class Remove_Duplicates_from_Sorted_Array {

	public static void main(String[] args) {
		int[] a1 = { 1, 2, 2, 3, 3, 4, 5, 5 };
		Remove_Duplicates_from_Sorted_Array r = new Remove_Duplicates_from_Sorted_Array();
		int len = r.removeDuplicates(a1);
		System.out.println(len);
//		for (int i = 0; i < len; i++)
//			System.out.print(a1[i] + " ");
	}

	public int removeDuplicates(int[] A) {
		int pos = 0;
		for (int i = 1; i < A.length; i++)
			if (A[i] != A[i - 1])
				A[++pos] = A[i];
		return pos + 1;
	}
}
