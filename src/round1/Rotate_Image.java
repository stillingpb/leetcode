package round1;

public class Rotate_Image {

	public static void main(String[] args) {
//		int[][] m = { { 1, 2, 3, 4 }, { 4, 5, 6, 7 }, { 7, 8, 9, 10 },
//				{ 11, 12, 13, 14 } };
		int[][] m = { { 1,2},{3,4}};
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++)
				System.out.print(m[i][j] + " ");
			System.out.println();
		}
		Rotate_Image r = new Rotate_Image();
		r.rotate(m);
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++)
				System.out.print(m[i][j] + " ");
			System.out.println();
		}
	}

	public void rotate(int[][] matrix) {
		int n = matrix.length;
		for (int i = 0; i < n / 2; i++)
			for (int j = i; j < n - i - 1; j++)
				rotate(matrix, i, j, n);
	}

	private void rotate(int[][] matrix, int i, int j, int n) {
		int temp = matrix[i][j];
		matrix[i][j] = matrix[n - j - 1][i];
		matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
		matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
		matrix[j][n - i - 1] = temp;
	}
}
