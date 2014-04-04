package round1;

/**
 * 堆排
 */
public class TwoSum2 {
	public static void main(String[] args) {
		int[] numbers = { 3, 2, 4 };
		int[] ans = new TwoSum2().twoSum(numbers, 6);
		System.out.println(ans[0] + " " + ans[1]);
		// new TwoSum().headSort(numbers);
		// for (int i : numbers)
		// System.out.println(i + " ");
	}

	private void swap(int[] num, int i, int j) {
		num[i] ^= num[j];
		num[j] ^= num[i];
		num[i] ^= num[j];
	}

	private void heapAdjust(int[] num, int[] index, int i) {
		for (int par = (i - 1) / 2; i > 0; i = par, par = (i - 1) / 2) {
			if (num[i] > num[par]) {
				swap(index, i, par);
				swap(num, i, par);
			} else
				break;
		}
	}

	private void heapSort(int[] num, int index[]) {
		for (int i = 1; i < num.length; i++)
			heapAdjust(num, index, i);

		for (int i = num.length - 1; i > 0; i--) {
			swap(num, 0, i);
			swap(index, 0, i);
			for (int j = 0; j <= i / 2 - 1;) {
				int maxSub = j * 2 + 1;
				if (j * 2 + 2 < i && num[j * 2 + 1] < num[j * 2 + 2])
					maxSub = j * 2 + 2;

				if (num[j] < num[maxSub]) {
					swap(num, j, maxSub);
					swap(index, j, maxSub);
					j = maxSub;
				} else
					break;
			}
		}
	}

	public int[] twoSum(int[] numbers, int target) {
		int index[] = new int[numbers.length];
		for (int i = 0; i < numbers.length; i++)
			index[i] = i + 1;

		heapSort(numbers, index);

		int i = 0, j = numbers.length - 1;
		while (true) {
			int sum = numbers[i] + numbers[j];
			if (sum < target)
				i++;
			else if (sum > target)
				j--;
			else {
				if (index[i] > index[j])
					return new int[] { index[j], index[i] };
				else
					return new int[] { index[i], index[j] };
			}
		}
	}
}
