package round1;

import java.util.Stack;

public class Largest_Rectangle_in_Histogram {

	public static void main(String[] args) {
		int[] height = { 4, 2, 0, 3, 2, 5 };
		Largest_Rectangle_in_Histogram l = new Largest_Rectangle_in_Histogram();
		System.out.println(l.largestRectangleArea(height));
	}

	public int largestRectangleArea(int[] height) {
		Stack<Integer> index = new Stack<Integer>();
		int i = 0;
		int maxArea = 0;
		while (i < height.length) {
			if (index.isEmpty() || height[index.peek()] <= height[i])
				index.push(i++);
			else {
				int pos = index.pop();
				int len = index.isEmpty() ? i : (i - index.peek() - 1);
				maxArea = Math.max(maxArea, len * height[pos]);
			}
		}
		while (!index.isEmpty()) {
			int pos = index.pop();
			int len = index.isEmpty() ? i : (i - index.peek() - 1);
			maxArea = Math.max(maxArea, len * height[pos]);
		}
		return maxArea;
	}
}
