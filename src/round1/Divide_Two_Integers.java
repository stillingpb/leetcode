package round1;

public class Divide_Two_Integers {
	public static void main(String[] args) {
		Divide_Two_Integers d = new Divide_Two_Integers();
		System.out.println(d.divide(-2147483648, 1));
		System.out.println(d.divide(-2147483648, 3));

		System.out.println(d.divide(2147483647, 1));
		System.out.println(d.divide(2147483647, 3) + " " + 2147483647 / 3);
		System.out.println(d.divide(100, 10));
		System.out.println(d.divide(15, 7));
		System.out.println(d.divide(14, 7));
		System.out.println(d.divide(7, 15));
		System.out.println(d.divide(0, -1));
		System.out.println(d.divide(1, -1));
	}

	public int divide(int dividend, int divisor) {
		boolean neg = dividend > 0 ^ divisor > 0;
		long dividendLong = Math.abs((long) dividend);
		long divisorLong = Math.abs((long) divisor);
		int baseCount = 0;
		long base = 0;
		while (true) {
			long val = divisorLong;
			long count = 1;
			while (base + val <= dividendLong) {
				val <<= 1;
				count <<= 1;
			}
			if (val == divisorLong)
				break;
			base += val >> 1;
			baseCount += count >> 1;
		}
		return neg ? -baseCount : baseCount;
	}
}
