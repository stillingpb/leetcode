package round1;

public class Unique_Paths {

	public static void main(String[] args) {
		System.out.println(new Unique_Paths().uniquePaths(3, 7));
	}

	public int uniquePaths(int m, int n) {// f(m,n) = f(m-1,n) + f(m,n-1)
		int matrix[][] = new int[m][n];
		for (int i = 0; i < n; i++)
			matrix[m - 1][i] = 1;
		for (int i = 0; i < m; i++)
			matrix[i][n - 1] = 1;

		for (int i = m - 2; i >= 0; i--)
			for (int j = n - 2; j >= 0; j--)
				matrix[i][j] = matrix[i + 1][j] + matrix[i][j + 1];
		return matrix[0][0];
	}
}
