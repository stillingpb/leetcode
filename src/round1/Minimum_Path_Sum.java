package round1;

public class Minimum_Path_Sum {
	public static void main(String[] args) {
		int grid[][] = { { 3, 4, 2 }, { 1, 2, 2 }, { 2, 3, 1 } };
		System.out.println(new Minimum_Path_Sum().minPathSum(grid));
	}

	public int minPathSum(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;

		int matrix[][] = new int[m][n];
		matrix[m - 1][n - 1] = grid[m - 1][n - 1];
		for (int i = m - 2; i >= 0; i--)
			matrix[i][n - 1] = matrix[i + 1][n - 1] + grid[i][n - 1];
		for (int i = n - 2; i >= 0; i--)
			matrix[m - 1][i] = matrix[m - 1][i + 1] + grid[m - 1][i];

		for (int i = m - 2; i >= 0; i--)
			for (int j = n - 2; j >= 0; j--)
				matrix[i][j] = grid[i][j]
						+ Math.min(matrix[i + 1][j], matrix[i][j + 1]);
		return matrix[0][0];
	}
}
