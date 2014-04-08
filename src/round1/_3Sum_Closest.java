package round1;

import java.util.Arrays;

public class _3Sum_Closest {

	public static void main(String[] args) {
		_3Sum_Closest s = new _3Sum_Closest();
		int closest = s.threeSumClosest(new int[] { 0, 1, 2 }, 3);
		System.out.println(closest);
	}

	private int minDis = Integer.MAX_VALUE;
	private int closest;

	public int threeSumClosest(int[] num, int target) {
		Arrays.sort(num);
		for (int i = 0; i < num.length - 2; i++) {
			if (i > 0 && num[i] == num[i - 1])
				continue;
			twoSumClosest(target, num, i);
		}
		return closest;
	}

	private void twoSumClosest(int target, int[] num, int i) {
		int j = i + 1;
		int k = num.length - 1;
		while (j < k) {
			int sum = num[i] + num[j] + num[k];
			int dis = Math.abs(sum - target);
			if (dis < minDis) {
				minDis = dis;
				closest = sum;
			}
			if (sum < target)
				j++;
			else
				k--;
		}
	}
}
