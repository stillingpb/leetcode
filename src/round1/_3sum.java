package round1;

import java.util.ArrayList;
import java.util.Arrays;

public class _3sum {
	public static void main(String[] args) {
		_3sum s = new _3sum();
		ArrayList<ArrayList<Integer>> ans = s.threeSum(new int[] { });
		for (ArrayList<Integer> a : ans)
			System.out.println(a);
	}

	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		Arrays.sort(num);
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();

		for (int i = 0; i < num.length - 2; i++) {
			if (i > 0 && num[i] == num[i - 1])
				continue;
			twoSum(ans, num[i], num, i + 1);
		}

		return ans;
	}

	private void twoSum(ArrayList<ArrayList<Integer>> ans, int target,
			int[] num, int begin) {
		int i = begin;
		int j = num.length - 1;
		while (i < j) {
			int sum = num[i] + num[j];
			if (target + sum == 0) {
				ans.add(makeTriples(num, target, num[i], num[j]));
				do {
					i++;
				} while (i < j && num[i] == num[i - 1]);
				do {
					j--;
				} while (i < j && num[j] == num[j + 1]);
			} else if (target + sum < 0) {
				i++;
			} else {
				j--;
			}
		}
	}

	private ArrayList<Integer> makeTriples(int[] num, int a, int b, int c) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(a);
		list.add(b);
		list.add(c);
		return list;
	}
}
