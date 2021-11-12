package Educative.TopKElements;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Challenge1 {
    public static String reorganizeString(String str, int k) {
        if (k <= 1) {
            return str;
        }

        String result = "";
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (Character chr : str.toCharArray()) {
            frequencyMap.put(chr, frequencyMap.getOrDefault(chr, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
                (e1, e2) -> e2.getValue() - e1.getValue());
        maxHeap.addAll(frequencyMap.entrySet());

        Queue<Map.Entry<Character, Integer>> queue = new LinkedList<>();

        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> currentEntry = maxHeap.poll();
            result += currentEntry.getKey();
            currentEntry.setValue(currentEntry.getValue() - 1);
            queue.offer(currentEntry);
            if (queue.size() == k) {
                Map.Entry<Character, Integer> entry = queue.poll();
                if (entry.getValue() > 0) {
                    maxHeap.add(entry);
                }
            }
        }
        return result.length() == str.length() ? result : "";
    }

    public static void main(String[] args) {
        System.out.println("Reorganized string: " + reorganizeString("mmpp", 2));
        System.out.println("Reorganized string: " + reorganizeString("Programming", 3));
        System.out.println("Reorganized string: " + reorganizeString("aab", 2));
        System.out.println("Reorganized string: " + reorganizeString("aappa", 3));
    }
}
