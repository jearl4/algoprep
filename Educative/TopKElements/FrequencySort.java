package Educative.TopKElements;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FrequencySort {
    public static String sortCharacterByFrequency(String str) {
        String result = "";
        Map<Character, Integer> charFrequencyMap = new HashMap<Character, Integer>();
        for (Character character : str.toCharArray()) {
            charFrequencyMap.put(character, charFrequencyMap.getOrDefault(character, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((c1, c2) -> c2.getValue() - c1.getValue());

        maxHeap.addAll(charFrequencyMap.entrySet());

        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> entry = maxHeap.poll();
            for (int i = 0; i < entry.getValue(); i++) {
                result += entry.getKey();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String result = FrequencySort.sortCharacterByFrequency("Programming");
        System.out.println("Here is the given string after sorting characters by frequency: " + result);

        result = FrequencySort.sortCharacterByFrequency("abcbab");
        System.out.println("Here is the given string after sorting characters by frequency: " + result);
    }
}
