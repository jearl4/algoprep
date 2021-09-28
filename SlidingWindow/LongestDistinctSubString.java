import java.util.HashMap;
import java.util.Map;

public class LongestDistinctSubString {
    public static int distinctString(String word, int size){
        int resultLength = 0, windowStart = 0;
        Map<Character, Integer> charFrequencyMap = new HashMap<Character,Integer>();
        for(int windowEnd = 0; windowEnd < word.length(); windowEnd++){
           char rightChar = word.charAt(windowEnd);
           charFrequencyMap.put(rightChar, charFrequencyMap.getOrDefault(rightChar, 0) + 1);
           while (charFrequencyMap.size() > size) {
               char leftChar = word.charAt(windowStart);
               charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar)-1);
               if(charFrequencyMap.get(leftChar) == 0){
                   charFrequencyMap.remove(leftChar);
               }
               windowStart++;
           }
           resultLength = Math.max(resultLength, windowEnd - windowStart + 1);
        }
        return resultLength;
    }
    public static void main(String[] args) {
        System.out.println(distinctString("araaci", 2));
    }
}
