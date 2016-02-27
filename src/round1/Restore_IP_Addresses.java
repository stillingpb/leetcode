package round1;

import java.util.ArrayList;
import java.util.List;

public class Restore_IP_Addresses {

    public static void main(String[] args) {
        Restore_IP_Addresses r = new Restore_IP_Addresses();
        System.out.println(r.restoreIpAddresses("25525511135"));
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        restoreIpAddresses(ans, s, 0, 0, "");
        return ans;
    }

    private void restoreIpAddresses(List<String> ans, String s, int pos, int level, String str) {
        if (level == 3) {
            String sub = s.substring(pos);
            if (isIllegal(sub)) {
                ans.add(str + sub);
            }
            return;
        }
        for (int i = pos + 1, len = s.length(); i < len && i <= pos + 3; i++) {
            String sub = s.substring(pos, i);
            if (!isIllegal(sub)) {
                break;
            }
            restoreIpAddresses(ans, s, i, level + 1, str + sub + ".");
        }
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
