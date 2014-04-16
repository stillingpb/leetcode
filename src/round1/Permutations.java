package round1;

import java.util.ArrayList;

public class Permutations {

	public static void main(String[] args) {
		Permutations p = new Permutations();
		System.out.println(p.permute(new int[] {}));
	}

	public ArrayList<ArrayList<Integer>> permute(int[] num) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		permute(ans, num, 0);
		return ans;
	}

	private void permute(ArrayList<ArrayList<Integer>> ans, int[] num, int begin) {
		ArrayList<Integer> sol = new ArrayList<Integer>();
		for (int n : num)
			sol.add(n);
		ans.add(sol);
		if (begin == num.length - 1)
			return;
		for (int i = begin; i < num.length - 1; i++)
			for (int j = i + 1; j < num.length; j++) {
				swap(num, i, j);
				permute(ans, num, i + 1);
				swap(num, i, j);
			}
	}

	private void swap(int[] num, int i, int j) {
		num[i] ^= num[j];
		num[j] ^= num[i];
		num[i] ^= num[j];
	}
}
