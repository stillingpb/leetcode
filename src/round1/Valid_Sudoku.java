package round1;

import java.util.Arrays;

public class Valid_Sudoku {

	public static void main(String[] args) {
		String str[] = { ".........", "......3..", "...18....", "...7.....",
				"....1.97.", ".........", "...36.1..", ".........", ".......2." };
		char ch[][] = new char[9][9];
		for (int i = 0; i < 9; i++)
			for (int j = 0; j < 9; j++)
				ch[i][j] = str[i].charAt(j);
		Valid_Sudoku v = new Valid_Sudoku();

		System.out.println(v.isValidSudoku(ch));
	}

	public boolean isValidSudoku(char[][] board) {
		boolean occur[] = new boolean[9];
		for (int i = 0; i < 9; i++) {
			Arrays.fill(occur, false);
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == '.')
					continue;
				int index = board[i][j] - '1';
				if (occur[index])
					return false;
				occur[index] = true;
			}
		}

		for (int j = 0; j < 9; j++) {
			Arrays.fill(occur, false);
			for (int i = 0; i < 9; i++) {
				if (board[i][j] == '.')
					continue;
				int index = board[i][j] - '1';
				if (occur[index])
					return false;
				occur[index] = true;
			}
		}

		for (int i = 0; i < 9; i++) {
			int baseRaw = i / 3 * 3;
			int baseCol = i % 3 * 3;
			Arrays.fill(occur, false);
			for (int j = 0; j < 9; j++) {
				char ch = board[baseRaw + j / 3][baseCol + j % 3];
				if (ch == '.')
					continue;
				int index = ch - '1';
				if (occur[index])
					return false;
				occur[index] = true;
			}
		}
		return true;
	}
}
