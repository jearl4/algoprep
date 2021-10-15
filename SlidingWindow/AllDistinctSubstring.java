package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class AllDistinctSubstring {
    public static int getSubString(String input) {
        int result = 0, windowStart = 0;
        Map<Character, Integer> inputMap = new HashMap<>();
        for (int windowEnd = 0; windowEnd < input.length(); windowEnd++) {
            char rightChar = input.charAt(windowEnd);
            if (inputMap.containsKey(rightChar)) {
                windowStart = Math.max(windowStart, inputMap.get(rightChar) + 1);
            }
            inputMap.put(rightChar, windowEnd);
            result = Math.max(result, windowEnd - windowStart + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(getSubString("aabccbb"));
    }
    
}
