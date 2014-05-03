package round1;

public class Climbing_Stairs {

	public static void main(String[] args) {
		Climbing_Stairs c = new Climbing_Stairs()
		;
		System.out.println(c.climbStairs(4));
	}

	public int climbStairs(int n) {
		int n1 = 1;
		int n2 = 1;
		for (int i = 2; i <= n; i++) {
			int temp = n1 + n2;
			n1 = n2;
			n2 = temp;
		}
		return n2;
	}
}
