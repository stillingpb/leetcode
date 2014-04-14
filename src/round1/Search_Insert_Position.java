package round1;

public class Search_Insert_Position {

	public static void main(String[] args) {
		int A[] = { 1, 3, 5, 6 };
		Search_Insert_Position s = new Search_Insert_Position();
		System.out.println(s.searchInsert(A, 5));
		System.out.println(s.searchInsert(A, 2));
		System.out.println(s.searchInsert(A, 7));
		System.out.println(s.searchInsert(A, 0));
	}

	public int searchInsert(int[] A, int target) {
		int start = 0;
		int end = A.length - 1;
		while (start <= end) {
			int mid = (start + end) >>> 1;
			int val = A[mid];
			if (val == target)
				return mid;
			else if (val < target)
				start = mid + 1;
			else
				end = mid - 1;
		}
		return start;
	}
}
