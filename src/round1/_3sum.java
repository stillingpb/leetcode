package round1;

import java.util.ArrayList;
import java.util.Arrays;

public class _3sum {
	public static void main(String[] args) {
		_3sum s = new _3sum();
		System.out.println(s.threeSum(new int[] { -1, 0, 1, 2, -1, -4 }));
	}

	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		Arrays.sort(num);
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < num.length - 2; i++) {
			if (i > 0 && num[i] == num[i - 1])
				continue;
			for (int j = i + 1; j < num.length - 1; j++) {
				if (j > i + 1 && num[j] == num[j - 1])
					continue;
				if (num[i] + num[j] > 0)
					break;
				for (int k = j + 1; k < num.length; k++) {
					if (k > j + 1 && num[k] == num[k - 1])
						continue;
					int sum = num[i] + num[j] + num[k];
					if (sum > 0)
						break;
					else if (sum == 0)
						ans.add(addTriple(num, i, j, k));
				}
			}
		}
		return ans;
	}

	private ArrayList<Integer> addTriple(int[] num, int i, int j, int k) {
		ArrayList<Integer> triple = new ArrayList<Integer>();
		triple.add(num[i]);
		triple.add(num[j]);
		triple.add(num[k]);
		return triple;
	}
}
