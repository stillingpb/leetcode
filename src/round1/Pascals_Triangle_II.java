package round1;

import java.util.ArrayList;

public class Pascals_Triangle_II {

	public static void main(String[] args) {
		Pascals_Triangle_II p = new Pascals_Triangle_II();
		System.out.println(p.getRow(2));
	}

	public ArrayList<Integer> getRow(int rowIndex) {
		ArrayList<Integer> row = new ArrayList<Integer>();
		row.add(1);
		for (int i = 1; i < rowIndex + 1; i++) {
			int pre = row.get(i - 1);
			for (int j = 1; j < i; j++) {
				int cur = row.get(j);
				row.set(j, pre + cur);
				pre = cur;
			}
			row.add(1);
		}
		return row;
	}

}
