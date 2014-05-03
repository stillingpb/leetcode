package round1;

public class Unique_Paths_II {

	public static void main(String[] args) {
		int[][] grid = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
		Unique_Paths_II u = new Unique_Paths_II();
		System.out.println(u.uniquePathsWithObstacles(grid));
	}

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int[][] grid = new int[m][n];
		for (int i = m - 1; i >= 0; i--) {
			if (obstacleGrid[i][n - 1] == 1)
				break;
			grid[i][n - 1] = 1;
		}
		for (int i = n - 1; i >= 0; i--) {
			if (obstacleGrid[m - 1][i] == 1)
				break;
			grid[m - 1][i] = 1;
		}
		for (int i = m - 2; i >= 0; i--)
			for (int j = n - 2; j >= 0; j--) {
				if (obstacleGrid[i][j] == 1)
					continue;
				grid[i][j] = grid[i + 1][j] + grid[i][j + 1];
			}
		return grid[0][0];
	}
}
