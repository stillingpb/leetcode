package round1;

import java.util.ArrayList;

public class Pascals_Triangle {

	public static void main(String[] args) {
		Pascals_Triangle p = new Pascals_Triangle();
		ArrayList<ArrayList<Integer>> ans = p.generate(1);
		System.out.println(ans);
	}

	public ArrayList<ArrayList<Integer>> generate(int numRows) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		if(numRows == 0)
			return ans;
		ArrayList<Integer> pre = new ArrayList<Integer>();
		pre.add(1);
		ans.add(pre);
		for (int i = 1; i < numRows; i++) {
			ArrayList<Integer> line = new ArrayList<Integer>();
			line.add(1);
			for (int j = 1; j < i; j++)
				line.add(pre.get(j) + pre.get(j - 1));
			line.add(1);
			ans.add(line);
			pre = line;
		}
		return ans;
	}

}
