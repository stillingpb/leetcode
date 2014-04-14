package round1;

public class Reverse_Integer {

	public static void main(String[] args) {
		Reverse_Integer r = new Reverse_Integer();
		System.out.println(r.reverse(-1000));
		System.out.println(r.reverse(-9009));
		System.out.println(r.reverse(-1000000003));
	}

	public int reverse(int x) {
		boolean negtive = x < 0;
		x = Math.abs(x);
		long ans = 0;
		while (x != 0) {
			ans = ans * 10 + x % 10;
			x /= 10;
		}
		if (ans > Integer.MAX_VALUE)
			return negtive ? Integer.MIN_VALUE : Integer.MAX_VALUE;
		else
			return (int) (negtive ? -ans : ans);
	}
}
