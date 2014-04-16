package round1;

public class Search_in_Rotated_Sorted_Array_II {
	public static void main(String[] args) {
		Search_in_Rotated_Sorted_Array_II s = new Search_in_Rotated_Sorted_Array_II();

		int[] a = { 1, 1, 1, 2,3,1, 1, 1 };
		System.out.println(s.search(a, 4));
	}

	public boolean search(int[] A, int target) {
		int pivote = searchPivote(A, 1, A.length - 1);

		// left search of pivote
		int start = 0;
		int end = pivote - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			int val = A[mid];
			if (val == target)
				return true;
			else if (val < target)
				start = mid + 1;
			else
				end = mid - 1;
		}

		// right search of pivote
		start = pivote;
		end = A.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			int val = A[mid];
			if (val == target)
				return true;
			else if (val < target)
				start = mid + 1;
			else
				end = mid - 1;
		}
		return false;
	}
	
	private int searchPivote(int[] A, int start, int end) {
		while (start < end && A[0] == A[start])
			start++;
		while (start < end && A[0] == A[end])
			end--;
		// search pivote
		while (start <= end) {
			int pivote = (start + end) / 2;
			int val = A[pivote];
			if (val < A[0])
				end = pivote - 1;
			else
				start = pivote + 1;
		}
		return start;
	}
}
