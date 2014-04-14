package round1;

public class Pow {

	public static void main(String[] args) {
		Pow p = new Pow();
		System.out.println(p.pow(-1, -2147483648));
	}

	double pow2(double x, int n) {
		double ans = 1;
		for (int i = 0; i < n; i++)
			ans *= x;
		return ans;
	}

	public double pow(double x, int n) {
		if (n == 0)
			return 1;
		boolean negFlag = false;
		boolean overflow = false;
		if (n < 0) {
			if (Integer.MIN_VALUE == n) {
				n = Integer.MAX_VALUE;
				overflow = true;
			} else
				n = -n;
			negFlag = true;
		}
		double ans = 1;
		double temp = x;
		while (n != 0) {
			if ((n & 1) == 1) {
				ans *= temp;
			}
			temp *= temp;
			n >>= 1;
		}
		if (negFlag) {
			if (overflow)
				return 1.0 / (ans * x);
			return 1.0 / ans;
		}
		return ans;
	}
}
