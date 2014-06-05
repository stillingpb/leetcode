package round1;

public class Word_Search {

	public static void main(String[] args) {
		char board[][] = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };

		System.out.println(new Word_Search().exist(board, "ABCCED"));
		System.out.println(new Word_Search().exist(board, "SEE"));
		System.out.println(new Word_Search().exist(board, "ABCB"));
	}

	public boolean exist(char[][] board, String word) {
		boolean visited[][] = new boolean[board.length][board[0].length];
		for (int i = 0; i < board.length; i++)
			for (int j = 0; j < board[i].length; j++)
				if (board[i][j] == word.charAt(0) && isFinded(board, i, j, word, 0, visited))
					return true;
		return false;
	}

	private boolean isFinded(char[][] board, int i, int j, String word, int pos, boolean visited[][]) {
		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] == true
				|| board[i][j] != word.charAt(pos))
			return false;
		if (pos == word.length() - 1)
			return true;
		visited[i][j] = true;
		boolean finded = isFinded(board, i + 1, j, word, pos + 1, visited)
				|| isFinded(board, i - 1, j, word, pos + 1, visited)
				|| isFinded(board, i, j + 1, word, pos + 1, visited)
				|| isFinded(board, i, j - 1, word, pos + 1, visited);
		visited[i][j] = false;
		return finded;
	}
}
