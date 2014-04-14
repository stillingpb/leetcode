package round1;

public class Search_for_a_Range {

	public static void main(String[] args) {
		int A[] = { 1, 3, 5, 5, 6, 6 };
		Search_for_a_Range s = new Search_for_a_Range();
		int[] ans = s.searchRange(A, 3);
		System.out.println(ans[0] + " " + ans[1]);
	}

	public static int[] searchRange(int[] A, int target) {
		int start = 0;
		int end = A.length - 1;
		int mid = 0;
		while (start <= end) {
			mid = (start + end) >>> 1;
			int val = A[mid];
			if (val == target)
				break;
			else if (val < target)
				start = mid + 1;
			else
				end = mid - 1;
		}
		int[] area = new int[2];
		if (A[mid] == target) {
			int i = mid;
			while (i >= 0 && A[i] == target)
				i--;
			area[0] = i + 1;
			i = mid;
			while (i < A.length && A[i] == target)
				i++;
			area[1] = i - 1;
		} else {
			area[0] = area[1] = -1;
		}
		return area;
	}
}
