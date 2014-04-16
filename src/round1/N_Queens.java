package round1;

import java.util.ArrayList;
import java.util.Arrays;

public class N_Queens {

	public static void main(String[] args) {
		N_Queens n = new N_Queens();
		ArrayList<String[]> ans = n.solveNQueens(8);
		for (String[] sol : ans) {
			for (String s : sol)
				System.out.println(s);
			System.out.println();
		}
		System.out.println(ans.size());
	}

	public ArrayList<String[]> solveNQueens(int n) {
		ArrayList<String[]> ans = new ArrayList<String[]>();
		int row[] = new int[n];
		Arrays.fill(row, -1);
		solveNQueens(ans, row, 0, n);
		return ans;
	}

	private void solveNQueens(ArrayList<String[]> ans, int[] row, int rowPos,
			int n) {
		if (rowPos == row.length) {
			String[] solution = new String[row.length];
			for (int i = 0; i < row.length; i++) {
				char[] chs = new char[n];
				Arrays.fill(chs, '.');
				chs[row[i]] = 'Q';
				solution[i] = new String(chs);
			}
			ans.add(solution);
			return;
		}
		for (int i = 0; i < n; i++) {
			if (!isAttacked(row, rowPos, i)) {
				row[rowPos] = i;
				solveNQueens(ans, row, rowPos + 1, n);
				row[rowPos] = -1;
			}
		}
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
