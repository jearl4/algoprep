package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class SlidingWindowChallenge1 {
    public static boolean findPermutation(String text, String pattern) {
        int windowStart = 0, matched = 0;
        Map<Character, Integer> patternMap = new HashMap<>();
        for (char letter : pattern.toCharArray()) {
            patternMap.put(letter, patternMap.getOrDefault(letter, 0) + 1);
        }

        for (int windowEnd = 0; windowEnd < text.length(); windowEnd++) {
            char rightChar = text.charAt(windowEnd);
            if(patternMap.containsKey(rightChar)){
                patternMap.put(rightChar, patternMap.get(rightChar) - 1);
                if (patternMap.get(rightChar) == 0) {
                    matched++;
                }
            }

            if (matched == patternMap.size()) {
                return true;
            }

            if(windowEnd >= pattern.length() - 1){
                char leftChar = text.charAt(windowStart++);
                if(patternMap.containsKey(leftChar)){
                    if (patternMap.get(leftChar) == 0) {
                        matched--;
                    }
                    patternMap.put(leftChar, patternMap.get(leftChar) + 1);
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println("Permutation exist: " + findPermutation("oidbcaf", "abc"));
        System.out.println("Permutation exist: " + findPermutation("odicf", "dc"));
        System.out.println("Permutation exist: " + findPermutation("bcdxabcdy", "bcdyabcdx"));
        System.out.println("Permutation exist: " + findPermutation("aaacb", "abc"));
      }
}
