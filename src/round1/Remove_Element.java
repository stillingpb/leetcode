package round1;

public class Remove_Element {
	public static void main(String[] args) {
		Remove_Element r = new Remove_Element();
		System.out.println(r
				.removeElement(new int[] { 1, 2, 2, 3, 4, 2, 2 }, 2));
	}

	public int removeElement(int[] A, int elem) {
		int pos = 0;
		for (int i = 0; i < A.length; i++)
			if (A[i] != elem)
				A[pos++] = A[i];
		return pos;
	}
}
