package round1;

import java.util.ArrayList;

public class Permutation_Sequence {
	public static void main(String[] args) {
		Permutation_Sequence p = new Permutation_Sequence();
		for (int i = 1; i <= 11; i++)
			System.out.println(p.getPermutation(4, i));
	}

	public String getPermutation(int n, int k) {
		ArrayList<Integer> num = new ArrayList<Integer>();
		for (int i = 0; i < n; i++)
			num.add(i + 1);
		int[] weight = new int[n];
		weight[n - 1] = 1;
		for (int i = n - 2; i >= 0; i--)
			weight[i] = weight[i + 1] * (n - i - 1);

		StringBuilder sb = new StringBuilder();
		k--;
		for (int i = 0; i < n; i++) {
			int index = k / weight[i];
			k %= weight[i];
			sb.append(num.remove(index));
		}
		return sb.toString();
	}
}
