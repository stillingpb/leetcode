package round1;

import java.util.ArrayList;

public class Combinations {

	public static void main(String[] args) {
		Combinations c = new Combinations();
		System.out.println(c.combine(5, 2));
	}

	public ArrayList<ArrayList<Integer>> combine(int n, int k) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		int record[] = new int[k];
		combine(ans, n, k, record, k);
		return ans;
	}

	private void combine(ArrayList<ArrayList<Integer>> ans, int begin, int end,
			int[] record, int k) {
		if (k <= 0) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int r : record)
				list.add(r);
			ans.add(list);
			return;
		}
		for (int i = begin; i >= end; i--) {
			record[k - 1] = i;
			combine(ans, i - 1, k - 1, record, k - 1);
		}
	}
}
