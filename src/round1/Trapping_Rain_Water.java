package round1;

import java.util.Iterator;
import java.util.Stack;

public class Trapping_Rain_Water {

	public static void main(String[] args) {
		int[] A = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };

		int count = new Trapping_Rain_Water().trap(A);
		System.out.println(count);
	}

	public int trap(int[] A) {
		int count = 0;

		int mi = 0; // index of the max num
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(mi);
		
		return count;
	}

	private int cal(int[] a, int l, int r) {
		int small = a[l] < a[r] ? a[l] : a[r];
		int wrong = 0;
		for (int i = l + 1; i < r; i++)
			wrong += a[i];
		return small * (r - l - 1) - wrong;
	}
}
