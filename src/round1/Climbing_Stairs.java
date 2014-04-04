package round1;

public class Climbing_Stairs {
	public static void main(String[] args) {
		int n = new Climbing_Stairs().climbStairs(1000);
		System.out.println(n);
	}

	public int climbStairs(int n) {
		if (n <= 2)
			return n;
		int f1 = 1;
		int f2 = 2;
		for (int i = 3; i <= n; i++) {
			int temp = f1 + f2;
			f1 = f2;
			f2 = temp;
		}
		return f2;
	}
}
