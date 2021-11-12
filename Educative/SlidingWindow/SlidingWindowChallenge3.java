package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class SlidingWindowChallenge3 {
    public static String smallestSubstring(String string, String pattern) {
        int windowStart = 0, count = 0, minLength = string.length() + 1, subStringStart = 0;
        Map<Character, Integer> patternMap = new HashMap<>();

        for (char letter : pattern.toCharArray()) {
            patternMap.put(letter, patternMap.getOrDefault(letter, 0) + 1);
        }

        for (int windowEnd = 0; windowEnd < string.length(); windowEnd++) {
            char rightChar = string.charAt(windowEnd);
            if (patternMap.containsKey(rightChar)) {
                patternMap.put(rightChar, patternMap.get(rightChar) - 1);
                if (patternMap.get(rightChar) >= 0 ) {
                    count++;
                }
            }

            while (count == pattern.length()) {
                if (minLength > windowEnd - windowStart + 1) {
                    minLength = windowEnd - windowStart + 1;
                    subStringStart = windowStart;
                }

                char leftChar = string.charAt(windowStart++);
                if(patternMap.containsKey(leftChar)){
                    if (patternMap.get(leftChar) == 0) {
                        count--;
                    }
                    patternMap.put(leftChar, patternMap.get(leftChar) + 1);
                }
            }
        }

        return minLength > string.length() ? "" : string.substring(subStringStart, subStringStart + minLength);
    }
    public static void main(String[] args) {
        System.out.println(smallestSubstring("aabdec", "abc"));
        System.out.println(smallestSubstring("abdbca", "abc"));
        System.out.println(smallestSubstring("adcad", "abc"));
    }
}
