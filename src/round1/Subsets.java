package round1;

import java.util.ArrayList;
import java.util.Arrays;

public class Subsets {

	public static void main(String[] args) {
		Subsets s = new Subsets();
		ArrayList<ArrayList<Integer>> ans = s.subsets(new int[] { 4,1,0});
		System.out.println(ans);
	}

	public ArrayList<ArrayList<Integer>> subsets(int[] S) {
		Arrays.sort(S);
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		int count = 1 << S.length;
		for (int i = 0; i < count; i++) {
			int cur = i;
			ArrayList<Integer> curList = new ArrayList<Integer>();
			ans.add(curList);
			for (int j = 0; j < S.length; j++, cur >>= 1) {
				if ((cur & 1) == 1)
					curList.add(S[j]);
			}
		}
		return ans;
	}
}
