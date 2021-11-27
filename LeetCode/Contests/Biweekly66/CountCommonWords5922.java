package LeetCode.Contests.Biweekly66;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CountCommonWords5922 {
    public int countWords(String[] words1, String[] words2) {
        Map<String, Integer> map1 = new ConcurrentHashMap<String, Integer>();
        Map<String, Integer> map2 = new ConcurrentHashMap<String, Integer>();
        int count = 0;

        for (String word : words1) {
            map1.put(word, map1.getOrDefault(word, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            if (map1.get(entry.getKey()) > 1) {
                map1.remove(entry.getKey());
            }
        }

        for (String word : words2) {
            map2.put(word, map2.getOrDefault(word, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            if (map2.get(entry.getKey()) > 1) {
                map2.remove(entry.getKey());
            }
        }

        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            if (map2.containsKey(entry.getKey())) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        CountCommonWords5922 test = new CountCommonWords5922();
        String[] word1 = { "a", "ab" };
        String[] word2 = { "a", "a", "a", "ab" };
        test.countWords(word1, word2);
    }
}
