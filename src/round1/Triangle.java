package round1;

import java.util.ArrayList;
import java.util.Collections;

public class Triangle {

	public static void main(String[] args) {
		int[][] tri = { { 2 }};
		ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < tri.length; i++) {
			int[] t = tri[i];
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int j = 0; j < t.length; j++)
				list.add(t[j]);
			triangle.add(list);
		}
		System.out.println(new Triangle().minimumTotal(triangle));
	}

	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		if (triangle == null)
			return 0;
		for (int i = 1, level = triangle.size(); i < level; i++) {
			ArrayList<Integer> pre = triangle.get(i - 1);
			ArrayList<Integer> cur = triangle.get(i);

			cur.set(0, cur.get(0) + pre.get(0));
			cur.set(i, pre.get(i - 1) + cur.get(i));

			for (int j = 1; j < i; j++) {
				int left = pre.get(j - 1);
				int right = pre.get(j);
				int min = left < right ? left : right;
				cur.set(j, min + cur.get(j));
			}
		}
		return Collections.min(triangle.get(triangle.size() - 1));
	}
}
