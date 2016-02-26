package round2;

public class test318 {
    public static void main(String[] args) {
        System.out.println(new test318().maxProduct(
                new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"}));
        System.out.println(new test318().maxProduct(
                new String[]{"a", "ab", "abc", "d", "cd", "bcd", "abcd"}));
        System.out.println(new test318().maxProduct(new String[]{"a", "aa", "aaa", "aaaa"}));
    }

    public int maxProduct(String[] words) {
        int len = words.length;
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            String w = words[i];
            for (int j = 0, wordLen = w.length(); j < wordLen; j++) {
                nums[i] |= (1 << (w.charAt(j) - 'a'));
            }
        }
        int ans = 0;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if ((nums[i] & nums[j]) == 0) {
                    ans = Math.max(ans, words[i].length() * words[j].length());
                }
            }
        }
        return ans;
    }
}
