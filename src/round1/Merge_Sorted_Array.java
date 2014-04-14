package round1;

//Merge Sorted Array
public class Merge_Sorted_Array {

	public static void main(String[] args) {
		Merge_Sorted_Array m = new Merge_Sorted_Array();
		int[] a = new int[]{1,2,3,0,0,0};
		m.merge(a, 3, new int[]{0,2,4}, 3);
		for(int i : a)
			System.out.print(i+" ");
	}

	public void merge(int A[], int m, int B[], int n) {
		int ai = m - 1;
		int bi = n - 1;
		int i = m + n - 1;
		while (ai >= 0 && bi >= 0) {
			if (A[ai] > B[bi]) {
				A[i--] = A[ai--];
			} else {
				A[i--] = B[bi--];
			}
		}
		while (ai >= 0) {
			A[i--] = A[ai--];
		}
		while (bi >= 0) {
			A[i--] = B[bi--];
		}
	}
}
