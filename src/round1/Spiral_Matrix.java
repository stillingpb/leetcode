package round1;

import java.util.ArrayList;

public class Spiral_Matrix {

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		Spiral_Matrix s = new Spiral_Matrix();
		System.out.println(s.spiralOrder(matrix));
	}

	public ArrayList<Integer> spiralOrder(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return new ArrayList<Integer>();
		int m = matrix.length;
		int n = matrix[0].length;
		ArrayList<Integer> ans = new ArrayList<Integer>(m * n);
		int times = Math.min((m + 1) / 2, (n + 1) / 2);
		for (int i = 0; i < times; i++) {
			for (int j = i; j <= n - i - 1; j++)
				ans.add(matrix[i][j]);

			for (int j = i + 1; j <= m - i - 1; j++)
				ans.add(matrix[j][n - i - 1]);

			if (m - i - 1 != i)
				for (int j = n - i - 2; j >= i; j--)
					ans.add(matrix[m - i - 1][j]);

			if (n - i - 1 != i)
				for (int j = m - i - 2; j > i; j--)
					ans.add(matrix[j][i]);
		}
		return ans;
	}
}
