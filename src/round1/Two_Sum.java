package round1;

import java.util.HashMap;

public class Two_Sum {

	public static void main(String[] args) {
		int a[] = { 3, 5, 6, 1, 2 };
		Two_Sum t = new Two_Sum();
		a = t.twoSum(a, 11);
		for (int i : a)
			System.out.print(i + " ");
	}

	public int[] twoSum(int[] numbers, int target) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();// <number,index>
		int[] ans = new int[2];
		for (int i = 0; i < numbers.length; i++) {
			if (map.containsKey(target - numbers[i])) {
				ans[0] = map.get(target - numbers[i]) + 1;
				ans[1] = i + 1;
				break;
			}
			map.put(numbers[i], i);
		}
		return ans;
	}
}
