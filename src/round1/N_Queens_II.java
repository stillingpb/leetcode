package round1;

import java.util.Arrays;

public class N_Queens_II {

	public static void main(String[] args) {
		N_Queens_II n = new N_Queens_II();
		System.out.println(n.totalNQueens(8));
	}

	public int totalNQueens(int n) {
		int row[] = new int[n];
		Arrays.fill(row, -1);
		return solveNQueens(row, 0, n);
	}

	private int solveNQueens(int[] row, int rowPos, int n) {
		if (rowPos == row.length)
			return 1;
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (!isAttacked(row, rowPos, i)) {
				row[rowPos] = i;
				count += solveNQueens(row, rowPos + 1, n);
				row[rowPos] = -1;
			}
		}
		return count;
	}

	private boolean isAttacked(int[] row, int rowPos, int colPos) {
		for (int i = 0; i < row.length; i++) {
			if (row[i] == -1)
				continue;
			if (row[i] == colPos)
				return true;
			if (Math.abs(rowPos - i) == Math.abs(row[i] - colPos))
				return true;
		}
		return false;
	}

}
