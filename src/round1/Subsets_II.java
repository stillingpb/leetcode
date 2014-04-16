package round1;

import java.util.ArrayList;
import java.util.Arrays;

public class Subsets_II {

	public static void main(String[] args) {
		Subsets_II s = new Subsets_II();
		System.out.println(s.subsetsWithDup(new int[] {1}));
	}

	public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		ans.add(new ArrayList<Integer>());
		Arrays.sort(num);
		for (int i = 0; i < num.length; i++) {
			int count = 1;
			while (i < num.length - 1 && num[i] == num[i + 1]) {
				i++;
				count++;
			}
			for (int j = 1, size = ans.size(); j <= count; j++) {
				for (int k = 0; k < size; k++) {
					ArrayList<Integer> list = new ArrayList<Integer>(ans.get(k));
					for (int m = 0; m < j; m++)
						list.add(num[i]);
					ans.add(list);
				}
			}
		}
		return ans;
	}

}
