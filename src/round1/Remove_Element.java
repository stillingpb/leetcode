package round1;

public class Remove_Element {

	public static void main(String[] args) {
		Remove_Element r = new Remove_Element();
		int A[] = new int[] { 1 };
		int ans = r.removeElement(A, 2);
		for (int i = 0; i < ans; i++)
			System.out.print(A[i]);
	}

	public int removeElement(int[] A, int elem) {
		int curIndex = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] != elem) {
				A[curIndex++] = A[i];
			}
		}
		return curIndex;
	}
}
