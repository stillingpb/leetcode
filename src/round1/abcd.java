package round1;

public class abcd {
	/**
	 * false==left state, true == right state
	 */
	boolean[] state = new boolean[4];
	int[] val = new int[] { 1, 2, 5, 10 };
	int min = Integer.MAX_VALUE;

	void crossBridge(int deep, int count) {

		for (int i = 0; i < state.length - 1; i++) {
			if (state[i] == false) {
				state[i] = true;
				for (int j = i + 1; j < state.length; j++) {
					if (state[j] == false) {
						state[j] = true;
						back(deep, count + (val[i] > val[j] ? val[i] : val[j]));
						state[j] = false;
					}
				}
				state[i] = false;
			}
		}
	}

	/**
	 * beautiful one
	 * 
	 * @param deep
	 * @param count
	 */
	void crossBridge1(int deep, int count) {

		for (int i = 0; i < state.length - 1; i++) {
			if (state[i] == true)
				continue;
			state[i] = true;
			for (int j = i + 1; j < state.length; j++) {
				if (state[j] == true)
					continue;
				state[j] = true;
				back(deep, count + (val[i] > val[j] ? val[i] : val[j]));
				state[j] = false;
			}
			state[i] = false;
		}
	}

	// Stack<Integer> stack = new Stack<Integer>();

	void back(int deep, int count) {
		if (deep == 3) {
			if (min > count)
				min = count;
			// for (int s : stack)
			// System.out.print(s + " ");
			// System.out.println(count);
			return;
		}
		for (int i = 0; i < 4; i++) {
			if (state[i] == false)
				continue;
			state[i] = false;
			crossBridge(deep + 1, count + val[i]);
			state[i] = true;
		}
	}

	public static void main(String[] args) {
		abcd t = new abcd();
		t.crossBridge(1, 0);
		System.out.println(t.min);
	}
}
