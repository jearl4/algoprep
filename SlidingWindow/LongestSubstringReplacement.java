import java.util.HashMap;
import java.util.Map;

public class LongestSubstringReplacement {
    public static int longestSubstring(String string, int replacementCount) {
        int result = 0, windowStart = 0, maxRepeatedLetterCount = 0;
        Map<Character, Integer> stringMap = new HashMap<>();

        for (int windowEnd = 0; windowEnd < string.length(); windowEnd++) {
            char rightChar = string.charAt(windowEnd);
            stringMap.put(rightChar, stringMap.getOrDefault(rightChar, 0) + 1);
            maxRepeatedLetterCount = Math.max(maxRepeatedLetterCount, stringMap.get(rightChar));

            if(windowEnd - windowStart + 1 - maxRepeatedLetterCount > replacementCount){
                char leftChar = string.charAt(windowStart);
                stringMap.put(leftChar, stringMap.get(leftChar) - 1);
                windowStart++;
            }

            result = Math.max(result, windowEnd - windowStart + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(longestSubstring("aabccbb", 2));    
    }
}
