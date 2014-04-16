package round1;

import java.util.ArrayList;

public class Gray_Code {

	public static void main(String[] args) {
		Gray_Code g = new Gray_Code();
		System.out.println(g.grayCode(1));
	}

	public ArrayList<Integer> grayCode(int n) {
		ArrayList<Integer> ans = new ArrayList<Integer>();
		if (n == 0){
			ans.add(0);
			return ans;
		}
		ans.add(0);
		ans.add(1);
		for (int i = 1; i < n; i++)
			for (int j = ans.size() - 1, base = 1 << i; j >= 0; j--)
				ans.add(ans.get(j) | base);
		return ans;
	}
}
