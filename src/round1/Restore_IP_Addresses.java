package round1;

import java.util.ArrayList;

public class Restore_IP_Addresses {

	public static void main(String[] args) {
		Restore_IP_Addresses r = new Restore_IP_Addresses();
		System.out.println(r.restoreIpAddresses("1111"));
	}

	public ArrayList<String> restoreIpAddresses(String s) {
		ArrayList<String> ans = new ArrayList<String>();
		int len = s.length();
		for (int i = 0; i < len - 3; i++) {
			String sub1 = s.substring(0, i + 1);
			if (!isIllegal(sub1))
				break;
			for (int j = i + 1; j < len - 2; j++) {
				String sub2 = s.substring(i + 1, j + 1);
				if (!isIllegal(sub2))
					break;
				for (int k = j + 1; k < len - 1; k++) {
					String sub3 = s.substring(j + 1, k + 1);
					if (!isIllegal(sub3))
						break;
					String sub4 = s.substring(k + 1, len);
					if (!isIllegal(sub4))
						continue;
					StringBuilder sb = new StringBuilder();
					sb.append(sub1).append('.').append(sub2).append('.')
							.append(sub3).append('.').append(sub4);
					ans.add(sb.toString());
				}
			}
		}
		return ans;
	}

	private boolean isIllegal(String s) {
		int len = s.length();
		if (len > 3)
			return false;
		if (len > 1 && s.indexOf('0') == 0)
			return false;
		if (len == 3 && "255".compareTo(s) < 0)
			return false;
		return true;
	}
}
