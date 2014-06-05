package round1;

public class Sudoku_Solver {
	public static void main(String[] args) {
		String str[] = { "53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6",
				".6....28.", "...419..5", "....8..79" };
		char ch[][] = new char[9][9];
		for (int i = 0; i < 9; i++)
			for (int j = 0; j < 9; j++)
				ch[i][j] = str[i].charAt(j);
		Sudoku_Solver s = new Sudoku_Solver();
		s.solveSudoku(ch);
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(ch[i][j] + " ");
			}
			System.out.println();
		}
	}

	public void solveSudoku(char[][] board) {
		boolean[][] rawVisited = new boolean[9][10];
		boolean[][] colVisited = new boolean[9][10];
		boolean[][] cellVisited = new boolean[9][10];
		for (int i = 0; i < 9; i++)
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == '.')
					continue;
				int num = board[i][j] - '0';
				rawVisited[i][num] = true;
				colVisited[j][num] = true;
				cellVisited[(i / 3) * 3 + j / 3][num] = true;
			}
		isFinded(board, rawVisited, colVisited, cellVisited, 0, 0);
	}

	private boolean isFinded(char[][] board, boolean[][] rawVisited, boolean[][] colVisited,
			boolean[][] cellVisited, int i, int j) {
		if (i == 9)
			return true;
		if (board[i][j] != '.')
			return isFinded(board, rawVisited, colVisited, cellVisited, i + j / 8, j >= 8 ? 0 : j + 1);
		for (int k = 1; k <= 9; k++) {
			if (rawVisited[i][k] || colVisited[j][k] || cellVisited[(i / 3) * 3 + j / 3][k])
				continue;
			setVisit(i, j, k, true, rawVisited, colVisited, cellVisited, board);
			if (isFinded(board, rawVisited, colVisited, cellVisited, i + j / 8, j >= 8 ? 0 : j + 1))
				return true;
			setVisit(i, j, k, false, rawVisited, colVisited, cellVisited, board);
		}
		return false;
	}

	private void setVisit(int i, int j, int num, boolean status, boolean[][] rawVisited,
			boolean[][] colVisited, boolean[][] cellVisited, char[][] board) {
		rawVisited[i][num] = status;
		colVisited[j][num] = status;
		cellVisited[(i / 3) * 3 + j / 3][num] = status;
		board[i][j] = (status == true) ? (char) ('0' + num) : '.';
	}
}
