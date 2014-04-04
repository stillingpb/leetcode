package round1;

public class Unique_Paths2 {

	public static void main(String[] args) {
		System.out.println(new Unique_Paths().uniquePaths(3, 7));
	}

	public int uniquePaths(int m, int n) {// c(m+n-2,m-1)
		int step = m + n - 2;
		int choosed = m - 1;
		int up = 1;
		int down = 1;
		for (int i = 0; i < m - 1; i++) {
			up *= (step - i);
			down *= (choosed - i);
		}
		return up / down;
	}
}
