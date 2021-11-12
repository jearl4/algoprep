package Educative.TwoHeaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class MaximizeCapital {
    public static int findMaximumCapital(int[] capital, int[] profits, int numberOfProjects, int initialCapital) {
        int n = profits.length;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(n, (i1, i2) -> profits[i2] - profits[i1]);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(n, (i1, i2) -> capital[i1] - capital[i2]);

        for (int i = 0; i < profits.length; i++) {
            minHeap.offer(i);
        }

        int availableCapital = initialCapital;
        for (int i = 0; i < numberOfProjects; i++) {
            while (!minHeap.isEmpty() && capital[minHeap.peek()] <= availableCapital) {
                maxHeap.add(minHeap.poll());
            }

            if (maxHeap.isEmpty()) {
                break;
            }

            availableCapital += profits[maxHeap.poll()];
        }

        return availableCapital;
    }

    public static void main(String[] args) {
        int result = MaximizeCapital.findMaximumCapital(new int[] { 0, 1, 2 }, new int[] { 1, 2, 3 }, 2, 1);
        System.out.println("Maximum capital: " + result);
        result = MaximizeCapital.findMaximumCapital(new int[] { 0, 1, 2, 3 }, new int[] { 1, 2, 3, 5 }, 3, 0);
        System.out.println("Maximum capital: " + result);
    }
}
