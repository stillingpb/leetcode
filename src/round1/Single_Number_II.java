package round1;

public class Single_Number_II {

	public static void main(String[] args) {
		Single_Number_II s = new Single_Number_II();
		System.out.println(s.singleNumber(new int[] { 2, 2, 2, 1, 3, 3, 3 }));
	}

	public int singleNumber(int[] A) {
		int num[] = new int[32];
		for (int i : A)
			for (int j = 0; j < 32; j++) {
				if ((i & 1) == 1)
					num[j]++;
				i >>= 1;
			}
		int ans = 0;
		for (int i = 0; i < 32; i++)
			if (num[i] % 3 != 0)
				ans |= 1 << i;
		return ans;
	}
}
