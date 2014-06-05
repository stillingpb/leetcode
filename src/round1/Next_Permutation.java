package round1;

import java.util.Arrays;

public class Next_Permutation {

	public static void main(String[] args) {
		int[][] data = { { 4, 2, 0, 2, 3, 2, 0 }, { 1, 2, 3 }, { 1, 3, 2 }, { 2, 1, 3 }, { 2, 3, 1 },
				{ 3, 1, 2 }, { 3, 2, 1 } };
		Next_Permutation n = new Next_Permutation();
		for (int[] d : data) {
			n.nextPermutation(d);
			for (int i : d)
				System.out.print(i + " ");
			System.out.println();
		}
	}

	public void nextPermutation(int[] num) {
		for (int i = num.length - 2; i >= 0; i--) {
			int pos = i;
			for (int j = num.length - 1; j > i; j--)
				if (num[i] < num[j] && (pos == i || num[pos] > num[j]))
					pos = j;
			if (num[i] < num[pos]) {
				swap(num, i, pos);
				Arrays.sort(num, i + 1, num.length);
				return;
			}
		}
		Arrays.sort(num, 0, num.length);
	}

	private void swap(int[] num, int i, int j) {
		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}
}
