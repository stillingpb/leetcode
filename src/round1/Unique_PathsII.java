package round1;

public class Unique_PathsII {
	public static void main(String[] args) {
		int[][] grid = new int[][] { { 0 } };
		System.out.println(new Unique_PathsII().uniquePathsWithObstacles(grid));
	}

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int[][] matrix = new int[m][n];
		boolean obs = false;
		
		for (int i = m - 1; i >= 0; i--) {
			if (obs == false && obstacleGrid[i][n - 1] == 0)
				matrix[i][n - 1] = 1;
			else
				obs = true;
		}
		obs = false;
		for (int i = n - 1; i >= 0; i--) {
			if (obs == false && obstacleGrid[m - 1][i] == 0)
				matrix[m - 1][i] = 1;
			else
				obs = true;
		}
		
		for (int i = m - 2; i >= 0; i--)
			for (int j = n - 2; j >= 0; j--)
				if (obstacleGrid[i][j] != 1)
					matrix[i][j] = matrix[i][j + 1] + matrix[i + 1][j];
		return matrix[0][0];
	}
}
