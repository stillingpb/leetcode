package round1;

import java.util.Stack;

public class Maximal_Rectangle {

	public static void main(String[] args) {
		Maximal_Rectangle m = new Maximal_Rectangle();
		char[][] A = { { '0', '1', '1', '1' }, { '1', '1', '1', '1' },
				{ '1', '1', '1', '1' }, { '0', '0', '0', '0' } };
		System.out.println(m.maximalRectangle(A));
	}

	public int maximalRectangle(char[][] matrix) {
		if (matrix.length == 0)
			return 0;
		int rawLen = matrix.length;
		int colLen = matrix[0].length;
		int dp[] = new int[colLen];
		int maxArea = 0;
		for (int i = 0; i < rawLen; i++) {
			for (int j = 0; j < colLen; j++)
				if (matrix[i][j] == '0')
					dp[j] = 0;
				else
					dp[j]++;
			int area = calMaxArea(dp);
			maxArea = Math.max(maxArea, area);
		}
		return maxArea;
	}

	private int calMaxArea(int[] dp) {
		int maxArea = 0;
		Stack<Integer> stack = new Stack<Integer>();
		int i = 0;
		while (i < dp.length) {
			if (stack.isEmpty() || dp[stack.peek()] <= dp[i])
				stack.push(i++);
			else {
				int pos = stack.pop();
				int len = stack.isEmpty() ? i : (i - stack.peek() - 1);
				maxArea = Math.max(maxArea, dp[pos] * len);
			}
		}
		 while (!stack.isEmpty()) {
		 int pos = stack.pop();
		 int len = stack.isEmpty() ? i : (i - stack.peek() - 1);
		 maxArea = Math.max(maxArea, dp[pos] * len);
		 }
		return maxArea;
	}
}
