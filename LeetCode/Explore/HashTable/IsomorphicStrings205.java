package LeetCode.Explore.HashTable;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings205 {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();

        if (null == s || null == t) {
            return false;
        }

        if (s.length() != t.length()) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            if ((map.containsKey(s.charAt(i)) && t.charAt(i) != map.get(s.charAt(i)))) {
                return false;
            }

            if (!map.containsKey(s.charAt(i))) {
                if (!map.values().contains(t.charAt(i))) {
                    map.put(s.charAt(i), t.charAt(i));
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
