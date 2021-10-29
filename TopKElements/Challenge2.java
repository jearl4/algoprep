package TopKElements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Challenge2 {
    public static int scheduleTasks(char[] tasks, int k) {
        int result = 0;
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : tasks) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
                (e1, e2) -> e2.getValue() - e1.getValue());
        maxHeap.addAll(frequencyMap.entrySet());

        while (!maxHeap.isEmpty()) {
            List<Map.Entry<Character, Integer>> waitList = new ArrayList<>();
            int i = k + 1;
            for (; i >0 && !maxHeap.isEmpty(); i--) {
                result++;
                Map.Entry<Character, Integer> currentEntry = maxHeap.poll();
                if(currentEntry.getValue() > 1){
                    currentEntry.setValue(currentEntry.getValue() - 1);
                    waitList.add(currentEntry);
                }
            }
            maxHeap.addAll(waitList);
            if (!maxHeap.isEmpty()) {
                result += i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        char[] tasks = new char[] { 'a', 'a', 'a', 'b', 'c', 'c' };
        System.out.println("Minimum intervals needed to execute all tasks: " + scheduleTasks(tasks, 2));

        tasks = new char[] { 'a', 'b', 'a' };
        System.out.println("Minimum intervals needed to execute all tasks: " + scheduleTasks(tasks, 3));
    }
}
