package round1;

public class Search_a_2D_Matrix {
	public static void main(String[] args) {
		int[][] m = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 50 } };
		Search_a_2D_Matrix s = new Search_a_2D_Matrix();

		System.out.println(s.searchMatrix(m, 23));
	}

	public boolean searchMatrix(int[][] matrix, int target) {
		int rawLen = matrix.length;
		int colLen = matrix[0].length;
		int start = 0;
		int end = rawLen * colLen - 1;
		while (start <= end) {
			int mid = (start + end) >>> 1;
			int val = matrix[mid / colLen][mid % colLen];
			if (val == target)
				return true;
			else if (val < target)
				start = mid + 1;
			else
				end = mid - 1;
		}
		return false;
	}

	public int binarySearch(int[] array, int target) {
		int start = 0;
		int end = array.length - 1;
		int mid = 0;
		while (start <= end) {
			mid = (start + end) / 2;
			if (array[mid] == target)
				return mid;
			else if (array[mid] < target)
				start = mid + 1;
			else
				end = mid - 1;
		}
		return -start - 1;
	}
}
