package round1;

import java.util.ArrayList;
import java.util.Arrays;

public class Combination_Sum {

	public static void main(String[] args) {
		Combination_Sum c = new Combination_Sum();
		System.out.println(c.combinationSum(new int[] { 2, 3, 6, 7 }, 7));
	}

	public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates,
			int target) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		int[] count = new int[candidates.length];
		Arrays.sort(candidates);
		combinationSum(ans, candidates, target, count, candidates.length - 1);
		return ans;
	}

	private void combinationSum(ArrayList<ArrayList<Integer>> ans,
			int[] candidates, int target, int[] count, int level) {
		if (target == 0) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int i = 0; i < count.length; i++) {
				for (int j = 0; j < count[i]; j++)
					list.add(candidates[i]);
			}
			ans.add(list);
			return;
		}
		if (level < 0)
			return;
		int curNum = candidates[level];
		for (int i = target / curNum; i >= 0; i--) {
			count[level] = i;
			combinationSum(ans, candidates, target - i * curNum, count,
					level - 1);
		}
	}
}
