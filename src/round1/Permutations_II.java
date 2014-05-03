package round1;

import java.util.ArrayList;
import java.util.Arrays;

public class Permutations_II {

	public static void main(String[] args) {
		Permutations_II p = new Permutations_II();
		System.out.println(p.permuteUnique(new int[] { 1, 2, 3 }));
	}

	public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
		if (num.length == 0)
			return new ArrayList<ArrayList<Integer>>();
		Arrays.sort(num);
		ArrayList<Integer> unique = new ArrayList<Integer>();
		ArrayList<Integer> repeat = new ArrayList<Integer>();
		ArrayList<Integer> repeatCount = new ArrayList<Integer>();
		init(num, unique, repeat, repeatCount);

		ArrayList<ArrayList<Integer>> buf = new ArrayList<ArrayList<Integer>>();
		permuteUnique(buf, unique, 0);

		for (int i = 0; i < repeat.size(); i++) {
			ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
			int val = repeat.get(i);
			int count = repeatCount.get(i);
			for (ArrayList<Integer> b : buf)
				permuteUnique(list, b, val, count);
			buf = list;
		}

		return buf;
	}

	private void init(int[] num, ArrayList<Integer> unique,
			ArrayList<Integer> repeat, ArrayList<Integer> repeatCount) {
		int cur = num[0];
		int curCount = 1;
		unique.add(cur);
		for (int i = 1; i < num.length; i++) {
			if (cur != num[i]) {
				if (curCount > 1) {
					repeat.add(cur);
					repeatCount.add(curCount);
				}
				unique.add(num[i]);
				cur = num[i];
				curCount = 0;
			}
			curCount++;
		}
		if (curCount > 1) {
			repeat.add(cur);
			repeatCount.add(curCount);
		}
	}

	private void permuteUnique(ArrayList<ArrayList<Integer>> buf,
			ArrayList<Integer> unique, int start) {
		if (unique.size() == 1) {
			buf.add(unique);
			return;
		}
		ArrayList<Integer> temp = new ArrayList<Integer>(unique);
		buf.add(temp);
		int len = unique.size();
		if (start >= len - 1)
			return;
		for (int i = start; i < len - 1; i++) {
			for (int j = i + 1; j < len; j++) {
				swap(unique, i, j);
				permuteUnique(buf, unique, i + 1);
				swap(unique, i, j);
			}
		}
	}

	private void permuteUnique(ArrayList<ArrayList<Integer>> list,
			ArrayList<Integer> buf, int val, int count) {
		if (count <= 1) {
			ArrayList<Integer> buf1 = new ArrayList<Integer>(buf);
			list.add(buf1);
			return;
		}
		int pos = buf.lastIndexOf(val);
		for (int i = pos + 1, size = buf.size(); i <= size; i++) {
			buf.add(i, val);
			permuteUnique(list, buf, val, count - 1);
			buf.remove(i);
		}
	}

	private void swap(ArrayList<Integer> buf, int i, int j) {
		int temp = buf.get(i);
		buf.set(i, buf.get(j));
		buf.set(j, temp);
	}
}
