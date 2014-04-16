package round1;

public class Search_in_Rotated_Sorted_Array {

	public static void main(String[] args) {
		Search_in_Rotated_Sorted_Array s = new Search_in_Rotated_Sorted_Array();
		System.out.println(s.search(new int[] { 1, 3, 1, 1, 1 }, 1));
	}

	public int search(int[] A, int target) {
		int start = 0;
		int end = A.length - 1;
		int pivote = 0;

		// search pivote
		while (start <= end) {
			pivote = (start + end) / 2;
			int val = A[pivote];
			if (val < A[0])
				end = pivote - 1;
			else
				start = pivote + 1;
		}
		pivote = start;

		return pivote;

		// //left search of pivote
		// start = 0;
		// end = pivote - 1;
		// while (start <= end) {
		// int mid = (start + end) / 2;
		// int val = A[mid];
		// if (val == target)
		// return mid;
		// else if (val < target)
		// start = mid + 1;
		// else
		// end = mid - 1;
		// }
		//
		// //right search of pivote
		// start = pivote;
		// end = A.length - 1;
		// while (start <= end) {
		// int mid = (start + end) / 2;
		// int val = A[mid];
		// if (val == target)
		// return mid;
		// else if (val < target)
		// start = mid + 1;
		// else
		// end = mid - 1;
		// }
		// return -1;
	}
}
