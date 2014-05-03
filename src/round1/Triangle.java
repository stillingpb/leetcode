package round1;

import java.util.ArrayList;

public class Triangle {

	public static void main(String[] args) {
		int tri[][] = {{2},{ 3, 4 }, { 6, 5, 7 }, { 4, 1, 8, 3 }};
		ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < tri.length; i++) {
			ArrayList<Integer> line = new ArrayList<Integer>();
			for (int j = 0; j < tri[i].length; j++)
				line.add(tri[i][j]);
			triangle.add(line);
		}
		System.out.println(new Triangle().minimumTotal(triangle));
	}

	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		int n = triangle.size();
		if (n == 0)
			return 0;
		int dp[] = new int[n];
		dp[0] = triangle.get(0).get(0);
		for (int i = 1; i < n; i++) {
			ArrayList<Integer> line = triangle.get(i);
			dp[i] = line.get(i) + dp[i - 1];
			for (int j = i - 1; j > 0; j--)
				dp[j] = line.get(j) + Math.min(dp[j - 1], dp[j]);
			dp[0] += line.get(0);
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++)
			min = Math.min(min, dp[i]);
		return min;
	}
}
