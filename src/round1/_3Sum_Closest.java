package round1;

import java.util.Arrays;

public class _3Sum_Closest {

	public static void main(String[] args) {
		_3Sum_Closest s = new _3Sum_Closest();
		System.out.println(s.threeSumClosest(new int[] { -1, 2, 1, -4 }, 1));
	}

	public int threeSumClosest(int[] num, int target) {
		Arrays.sort(num);
		for (int i = 0; i < num.length - 2; i++)
			twoSumClosest(num, i, target);
		return closest;
	}

	int closest = 0;
	int minDis = Integer.MAX_VALUE;

	private void twoSumClosest(int[] num, int i, int target) {
		int j = i + 1;
		int k = num.length - 1;
		while (j < k) {
			int sum = num[i] + num[j] + num[k];
			int dis = Math.abs(sum - target);
			if (minDis > dis) {
				minDis = dis;
				closest = sum;
			}
			if (sum < target)
				j++;
			else if (sum > target)
				k--;
			else
				return;
		}
	}
}
