package round1;

import java.util.Stack;

/**
 * 快排
 * 
 * @author pb
 * 
 */
public class TwoSum3 {
	public static void main(String[] args) {
		int[] numbers = { 3, 2, 4, 3, 5, 3 };
		int[] ans = new TwoSum3().twoSum(numbers, 6);
		System.out.println(ans[0] + " " + ans[1]);
		// new TwoSum().headSort(numbers);
		// for (int i : numbers)
		// System.out.println(i + " ");
	}

	public int[] twoSum(int[] numbers, int target) {
		index = new int[numbers.length];
		for (int i = 0; i < numbers.length; i++)
			index[i] = i + 1;

		quickSort(numbers);
		// for (int i : numbers)
		// System.out.println(i + " ");

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

	int[] index;

	private void quickSort(int[] numbers) {
		int low = 0, high = numbers.length - 1;
		Stack<Integer> lstack = new Stack<Integer>();
		Stack<Integer> hstack = new Stack<Integer>();
		lstack.push(low);
		hstack.push(high);
		while (!lstack.isEmpty()) {
			low = lstack.pop();
			high = hstack.pop();
			if (high - low < 7) { // choose sort
				for (int i = low + 1; i <= high; i++) {
					int temp = numbers[i];
					int tempIndex = index[i];
					int j = i - 1;
					for (; j >= low; j--)
						if (numbers[j] > temp) {
							numbers[j + 1] = numbers[j];
							index[j + 1] = index[j];
						} else
							break;
					numbers[j + 1] = temp;
					index[j + 1] = tempIndex;
				}
				continue;
			}
			int pivotLoc = partition(numbers, low, high);
			if (low < pivotLoc - 1) {
				lstack.push(low);
				hstack.push(pivotLoc - 1);
			}
			if (pivotLoc + 1 < high) {
				lstack.push(pivotLoc + 1);
				hstack.push(high);
			}
		}
	}

	private void swap(int[] num, int i, int j) {
		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}

	private int partition(int[] numbers, int low, int high) {
		int mid = (low + high) / 2; // choose the mid one
		swap(numbers, low, mid);
		swap(index, low, mid);

		int temp = numbers[low];
		int tempIndex = index[low];
		while (low < high) {
			while (low < high && temp <= numbers[high])
				high--;
			numbers[low] = numbers[high];
			index[low] = index[high];
			while (low < high && temp >= numbers[low])
				low++;
			numbers[high] = numbers[low];
			index[high] = index[low];
		}
		numbers[low] = temp;
		index[low] = tempIndex;
		return low;
	}
}
