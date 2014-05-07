package round1;

import java.util.Arrays;

public class Jump_Game_II {

	public static void main(String[] args) {
		int A[] = { 3, 1, 2, 1, 5 };
		Jump_Game_II j = new Jump_Game_II();
		System.out.println(j.jump(A));
	}

	public int jump(int[] A) {
		int step = 0;
		int curr = 0;
		int farthest = 0;
		for (int i = 0; i < A.length; i++) {
			if (i > curr) {
				curr = farthest;
				step++;
			}
			farthest = Math.max(farthest, A[i] + i);
			if (farthest >= A.length - 1)
				break;
		}
		return step + 1;
	}
}
