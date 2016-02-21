package round1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Word_Break {

    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();
        String arr[] = {"a"};
        for (String str : arr)
            set.add(str);
        String s = "a";
        System.out.println(new Word_Break().wordBreak(s, set));
    }

    public boolean wordBreak(String s, Set<String> dict) {
        int len = s.length();
        boolean[] canReach = new boolean[len + 1];
        canReach[0] = true;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                String sub = s.substring(j, i + 1);
                if (canReach[j] && dict.contains(sub)) {
                    canReach[i + 1] = true;
                    break;
                }
            }
        }
        return canReach[len];
    }
}
