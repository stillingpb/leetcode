package round1;

public class Container_With_Most_Water {

	public static void main(String[] args) {
		Container_With_Most_Water c = new Container_With_Most_Water();
		System.out.println(c.maxArea(new int[] { 1, 2, 1, 3, 1, 1, 2, 1 }));
	}

	public int maxArea(int[] height) {
		int start = 0;
		int end = height.length - 1;
		int maxArea = 0;
		while (start < end) {
			int hi = 0;
			if (height[start] < height[end])
				hi = height[start++];
			else
				hi = height[end--];
			maxArea = Math.max(maxArea, (end - start + 1) * hi);
		}
		return maxArea;
	}
}
