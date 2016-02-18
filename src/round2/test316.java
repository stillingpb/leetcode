package round2;

import java.util.*;

public class test316 {
    public static void main(String[] args) {
        System.out.println(new test316().removeDuplicateLetters(null));
        System.out.println(new test316().removeDuplicateLetters(""));
        System.out.println(new test316().removeDuplicateLetters("a"));
        System.out.println(new test316().removeDuplicateLetters("aa"));
        System.out.println(new test316().removeDuplicateLetters("bbaa"));
        System.out.println(new test316().removeDuplicateLetters("baba"));
        System.out.println(new test316().removeDuplicateLetters("abab"));
        System.out.println(new test316().removeDuplicateLetters("bcabc"));
        System.out.println(new test316().removeDuplicateLetters("cbacdcbc"));
    }

    public String removeDuplicateLetters(String s) {
        if (s == null || "".equals(s)) {
            return s;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0, len = s.length(); i < len; i++) {
            char ch = s.charAt(i);
            Integer count = map.get(ch);
            if (count == null) {
                map.put(ch, 1);
            } else {
                map.put(ch, count + 1);
            }
        }
        Stack<Character> stack = new Stack<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0, len = s.length(); i < len; i++) {
            char ch = s.charAt(i);
            map.put(ch, map.get(ch) - 1);
            if (!set.contains(ch)) {
                while (!stack.isEmpty()) {
                    char peek = stack.peek();
                    if (peek < ch || map.get(peek) == 0) {
                        break;
                    }
                    stack.pop();
                    set.remove(peek);
                }
                stack.push(ch);
                set.add(ch);
            }
        }
        StringBuilder ans = new StringBuilder();
        for (char ch : stack) {
            ans.append(ch);
        }
        return ans.toString();
    }
}
