package round1;

public class Jump_Game {

	public static void main(String[] args) {
		Jump_Game j = new Jump_Game();
		int A[] = { 1, 2, 2, 0 };
		System.out.println(j.canJump(A));
	}

	public boolean canJump(int[] A) {
		if (A.length == 0 || A.length == 1)
			return true;
		int far = A[0];
		for (int i = 1; i < A.length && i <= far; i++) {
			far = Math.max(far, i + A[i]);
			if (far >= A.length - 1)
				return true;
		}
		return false;
	}
}
