package round2;

import java.util.Arrays;
import java.util.Comparator;

public class test179 {
    public static void main(String[] args) {
        System.out.println(new test179().largestNumber(new int[]{0, 0, 0, 0}));
        System.out.println(new test179().largestNumber(new int[]{0}));
        System.out.println(new test179().largestNumber(new int[]{0, 0, 1}));
        System.out.println(new test179().largestNumber(new int[]{34, 3, 2}));
        System.out.println(new test179().largestNumber(new int[]{234}));
    }

    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = "" + nums[i];
        }
        Arrays.sort(strs, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        StringBuilder sb = new StringBuilder();
        for (String s : strs)
            sb.append(s);
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }

}
