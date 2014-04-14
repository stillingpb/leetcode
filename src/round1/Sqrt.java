package round1;

public class Sqrt {

	public static void main(String[] args) {
		Sqrt s = new Sqrt();
		System.out.println(s.sqrt(16));
		System.out.println(s.sqrt(2147395599));
		System.out.println(s.sqrt(2));
		System.out.println(s.sqrt(3));
		System.out.println(s.sqrt(6));
		System.out.println(s.sqrt(7));
		System.out.println(s.sqrt(8));
		System.out.println(Math.sqrt(3));
		System.out.println(Integer.MAX_VALUE);
	}

	public int sqrt(int x) {
		int start = 0;
		int end = x;
		while (start <= end) {
			int mid = (start + end) / 2;
			long val = ((long) mid) * ((long) mid);
			if (val == x)
				return mid;
			else if (val > x)
				end = mid - 1;
			else
				start = mid + 1;
		}
		return start * start != x ? start - 1 : start;
	}
}
