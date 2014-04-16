package round1;

public class Spiral_Matrix_II {

	public static void main(String[] args) {
		Spiral_Matrix_II s = new Spiral_Matrix_II();
		int[][] m = s.generateMatrix(5);

		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++)
				System.out.print(m[i][j] + "\t");
			System.out.println();
		}
	}

	public int[][] generateMatrix(int n) {
		int[][] matrix = new int[n][n];
		int count = 1;
		for (int i = 0; i < (n + 1) / 2; i++) {

			for (int j = i; j < n - i - 1; j++)
				matrix[i][j] = count++;

			for (int j = i; j < n - i - 1; j++)
				matrix[j][n - i - 1] = count++;

			for (int j = n - i - 1; j > i; j--)
				matrix[n - i - 1][j] = count++;

			for (int j = n - i - 1; j > i; j--)
				matrix[j][i] = count++;
		}
		if (n % 2 == 1)
			matrix[n/2][n/2] = count;
		return matrix;
	}
}
