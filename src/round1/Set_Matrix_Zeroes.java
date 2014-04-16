package round1;

public class Set_Matrix_Zeroes {

	public static void main(String[] args) {
		int[][] m = { { 0, 0, 0, 5 }, { 4, 3, 1, 4 }, { 0, 1, 1, 4 },
				{ 1, 2, 1, 3 }, { 0, 0, 1, 1 } };
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++)
				System.out.print(m[i][j] + " ");
			System.out.println();
		}
		System.out.println();
		System.out.println();

		Set_Matrix_Zeroes s = new Set_Matrix_Zeroes();
		s.setZeroes(m);

		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++)
				System.out.print(m[i][j] + " ");
			System.out.println();
		}

	}

	public void setZeroes(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		boolean rawZero[] = new boolean[m];
		boolean colZero[] = new boolean[n];
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				if (matrix[i][j] == 0) {
					rawZero[i] = true;
					colZero[j] = true;
				}
		for (int i = 0; i < m; i++)
			if (rawZero[i] == true)
				for (int j = 0; j < n; j++)
					matrix[i][j] = 0;
		for (int j = 0; j < n; j++)
			if (colZero[j] == true)
				for (int i = 0; i < m; i++)
					matrix[i][j] = 0;
	}
}
