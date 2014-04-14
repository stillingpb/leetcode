package round1;

import java.util.ArrayList;
import java.util.Arrays;

public class Combination_Sum_II {

	public static void main(String[] args) {
		Combination_Sum_II c = new Combination_Sum_II();
		ArrayList<ArrayList<Integer>> ans = c.combinationSum2(new int[] { 10,
				1, 2, 7, 6, 1, 5 }, 8);
		System.out.println(ans);
	}

	public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
		Arrays.sort(num);
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		int[] count = new int[num.length];
		combinationSum2(ans, num, target, count, num.length - 1);
		return ans;
	}

	private void combinationSum2(ArrayList<ArrayList<Integer>> ans, int[] num,
			int target, int[] count, int level) {
		if (target == 0) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int i = 0; i < count.length; i++)
				if (count[i] == 1)
					list.add(num[i]);
			ans.add(list);
			return;
		}
		if (level < 0)
			return;
		if (num[level] <= target
				&& (level == num.length - 1 || num[level] != num[level + 1] || count[level + 1] == 1)) {
			count[level] = 1;
			combinationSum2(ans, num, target - num[level], count, level - 1);
			count[level] = 0;
		}
		combinationSum2(ans, num, target, count, level - 1);
	}
}
