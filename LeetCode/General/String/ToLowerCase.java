package LeetCode.General.String;

import java.util.HashMap;
import java.util.Map;

public class ToLowerCase {
    public String toLowerCase(String s) {
        Map<Character, Character> map = new HashMap<>();
        String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCase = "abcdefghijklmnopqrstuvwxyz";

        for (int i = 0; i < 26; i++) {
            map.put(upperCase.charAt(i), lowerCase.charAt(i));
        }

        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append(map.containsKey(c) ? map.get(c) : c);
        }
        return sb.toString();
    }
}
