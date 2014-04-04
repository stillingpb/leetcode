package round1;

import java.util.Arrays;

public class TwoSum {

	public static void main(String[] args) {
		int[] numbers = { 3, 2, 4 };
		int[] ans = new TwoSum().twoSum(numbers, 6);
		System.out.println(ans[0] + " " + ans[1]);
		// new TwoSum().headSort(numbers);
		// for (int i : numbers)
		// System.out.println(i + " ");
	}

	static class Num implements Comparable<Num> {
		int num;
		int index;

		public Num(int num, int index) {
			this.num = num;
			this.index = index;
		}

		@Override
		public int compareTo(Num arg0) {
			return this.num - arg0.num;
		}
	}

	public int[] twoSum(int[] numbers, int target) {
		Num[] num = new Num[numbers.length];
		for (int i = 0; i < numbers.length; i++)
			num[i] = new Num(numbers[i], i);
		Arrays.sort(num);
		int i = 0, j = numbers.length - 1;
		while (true) {
			int sum = num[i].num + num[j].num;
			if (sum < target)
				i++;
			else if (sum > target)
				j--;
			else {
				int index1 = num[i].index + 1;
				int index2 = num[j].index + 1;
				if (index1 > index2)
					return new int[] { index2, index1 };
				else
					return new int[] { index1, index2 };
			}
		}
	}
}
