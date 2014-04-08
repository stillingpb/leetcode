package round1;

public class Container_With_Most_Water {

	public static void main(String[] args) {
		int max = new Container_With_Most_Water().maxArea(new int[] {1,2,3,4,5,6});
		System.out.println(max);
	}

	public int maxArea(int[] height) {
		int max = 0;
		int start = 0, end = height.length - 1;
		while (start < end) {
			if (height[start] < height[end]) {
				max = Math.max(max, height[start] * (end - start));
				start++;
			} else {
				max = Math.max(max, height[end] * (end - start));
				end--;
			}
		}
		return max;
	}
}
