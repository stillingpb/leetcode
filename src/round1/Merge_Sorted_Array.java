package round1;

public class Merge_Sorted_Array {

	public static void main(String[] args) {
		Merge_Sorted_Array m = new Merge_Sorted_Array();
		int A[] = { 1, 2, 3, 4, 1, 1, 1, 1 };
		int B[] = { 2, 3, 4, 5 };
		m.merge(A, 4, B, 4);
		for (int i = 0; i < A.length; i++)
			System.out.print(A[i] + " ");
	}

	public void merge(int A[], int m, int B[], int n) {
		int i = m - 1;
		int j = n - 1;
		int k = m + n - 1;
		while (i >= 0 && j >= 0) {
			if (A[i] > B[j])
				A[k--] = A[i--];
			else
				A[k--] = B[j--];
		}
		while(j>=0)
			A[k--] = B[j--];
	}
}
