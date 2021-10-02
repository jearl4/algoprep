import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem2 {
    public static List<Integer> anagramIndex(String string, String pattern) {
        int windowStart = 0, count = 0;
        Map<Character, Integer> patternMap = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<Integer>();

        for (Character letter : pattern.toCharArray()) {
            patternMap.put(letter, patternMap.getOrDefault(letter, 0) + 1);
        }

        for (int windowEnd = 0; windowEnd < string.length(); windowEnd++) {
            char rightChar = string.charAt(windowEnd);
            if(patternMap.containsKey(rightChar)){
                patternMap.put(rightChar, patternMap.get(rightChar) - 1);
                if (patternMap.get(rightChar) == 0) {
                    count++;
                }
            }

            if(count == patternMap.size()){
                result.add(windowStart);
            }

            if(windowEnd >= pattern.length() - 1){
                char leftChar = string.charAt(windowStart++);
                if (patternMap.containsKey(leftChar)) {
                    if (patternMap.get(leftChar) == 0) {
                        count--;
                    }
                    patternMap.put(leftChar, patternMap.get(leftChar) + 1);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(anagramIndex("ppqp", "pq"));
        System.out.println(anagramIndex("abbcabc", "abc"));
    }
}
