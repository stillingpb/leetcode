package round1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class _4Sum {
	public static void main(String[] args) {
		_4Sum f = new _4Sum();
		System.out.println(f
				.fourSum(new int[] { -3, -2, -1, 0, 0, 1, 2, 3 }, 0));
	}

	public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
		HashSet<String> set = new HashSet<String>();
		Arrays.sort(num);
		for (int i = 0; i < num.length - 3; i++)
			for (int j = i + 1; j < num.length - 2; j++)
				twoSum(num, target - num[i] - num[j], set, j + 1,
						num.length - 1, num[i], num[j]);
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		for (String str : set) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			String[] nums = str.split(" ");
			for (String n : nums)
				list.add(Integer.parseInt(n));
			ans.add(list);
		}
		return ans;
	}

	private void twoSum(int[] num, int target, HashSet<String> set, int start,
			int end, int numi, int numj) {
		while (start < end) {
			int sum = num[start] + num[end];
			if (sum < target)
				start++;
			else if (sum > target)
				end--;
			else {
				StringBuilder sb = new StringBuilder();
				sb.append(numi).append(' ').append(numj).append(' ')
						.append(num[start]).append(' ').append(num[end]);
				set.add(sb.toString());
				start++;
				end--;
			}
		}
	}
}
