package round1;

import java.util.Stack;

public class Surrounded_Regions {

	public static void main(String[] args) {
		Surrounded_Regions s = new Surrounded_Regions();
		char[][] board = { 
				{ 'O', 'X', 'X', 'O' }, 
				{ 'X', 'O', 'O', 'X' },
				{ 'X', 'X', 'O', 'X' },
				{ 'X', 'X', 'X', 'O' } };
		board = new char[][]{{'O'}};
		s.solve(board);
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[0].length;j++)
				System.out.print(board[i][j]+" ");
			System.out.println();
		}
	}

	public void solve(char[][] board) {
		if(board.length == 0)
			return;
		int raw = board.length;
		int col = board[0].length;
		boolean[][] visit = new boolean[raw][col];
		for (int i = 0; i < raw; i++)
			for (int j = 0; j < col; j++) {
				if (board[i][j] == 'X')
					continue;
				coloring(board, visit, i, j);
			}
	}

	private void coloring(char[][] board, boolean[][] visit, int i, int j) {
		if (visit[i][j])
			return;
		Stack<Integer> posI = new Stack<Integer>();
		Stack<Integer> posJ = new Stack<Integer>();
		posI.push(i);
		posJ.push(j);
		boolean needDyed = true;
		while (!posI.isEmpty()) {
			i = posI.pop();
			j = posJ.pop();
			visit[i][j] = true;
			if (needDyed && (i == 0 || i == board.length - 1 || j == 0 || j == board[0].length - 1))
				needDyed = false;
			if (i > 0 && !visit[i - 1][j] && board[i - 1][j] == 'O') {
				posI.push(i - 1);
				posJ.push(j);
			}
			if (i < board.length - 1 && !visit[i + 1][j] && board[i + 1][j] == 'O') {
				posI.push(i + 1);
				posJ.push(j);
			}
			if (j > 0 && !visit[i][j - 1] && board[i][j - 1] == 'O') {
				posI.push(i);
				posJ.push(j - 1);
			}
			if (j < board[0].length - 1 && !visit[i][j + 1] && board[i][j + 1] == 'O') {
				posI.push(i);
				posJ.push(j + 1);
			}
		}
		if (!needDyed)
			return;
		posI.push(i);
		posJ.push(j);
		while (!posI.isEmpty()) {
			i = posI.pop();
			j = posJ.pop();
			board[i][j] = 'X';
			if (i > 0 && board[i - 1][j] == 'O') {
				posI.push(i - 1);
				posJ.push(j);
			}
			if (i < board.length - 1 && board[i + 1][j] == 'O') {
				posI.push(i + 1);
				posJ.push(j);
			}
			if (j > 0 && board[i][j - 1] == 'O') {
				posI.push(i);
				posJ.push(j - 1);
			}
			if (j < board[0].length - 1 && board[i][j + 1] == 'O') {
				posI.push(i);
				posJ.push(j + 1);
			}
		}
	}
}
