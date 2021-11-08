package LeetCode.Medium.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeats {
    public int lengthOfLongestSubstring(String s) {
        int length = 0;
        int start = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();

        for (int end = 0; end < s.length(); end++) {
            char rightChar = s.charAt(end);
            if (map.containsKey(rightChar)) {
                start = Math.max(start, map.get(rightChar) + 1);
            }
            map.put(rightChar, end);
            length = Math.max(length, end - start + 1);
        }
        return length;
    }
}
