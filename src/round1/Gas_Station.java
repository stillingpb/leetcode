package round1;

public class Gas_Station {

	public static void main(String[] args) {
		int[] gas = { 4 };
		int[] cost = { 5 };
		Gas_Station g = new Gas_Station();
		System.out.println(g.canCompleteCircuit(gas, cost));
	}

	public int canCompleteCircuit(int[] gas, int[] cost) {
		for (int i = 0, len = gas.length; i < len;) {
			int tank = 0;
			int j = 0;
			for (; j < len; j++) {
				int pos = (i + j) % len;
				tank += gas[pos] - cost[pos];
				if (tank < 0)
					break;
			}
			if (tank >= 0)
				return i;
			i += j + 1;
		}
		return -1;
	}

}
