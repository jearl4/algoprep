package Educative.TwoHeaps;

import java.util.PriorityQueue;

public class MedianOfNumberStream {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianOfNumberStream(){
        maxHeap = new PriorityQueue<>((a,b) -> b - a);
        minHeap = new PriorityQueue<>((a, b) -> a - b);
    }

    public void insertNumber(int num) {
        if (maxHeap.isEmpty() || maxHeap.peek() >= num) {
            maxHeap.add(num);
        }else{
            minHeap.add(num);
        }

        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        }else if (maxHeap.size() < minHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian(){
        if(maxHeap.size() == minHeap.size()){
            return maxHeap.peek() / 2.0 + minHeap.peek() / 2.0;
        }
        return maxHeap.peek();
    }
    
    public static void main(String[] args) {
        MedianOfNumberStream medianOfAStream = new MedianOfNumberStream();
        medianOfAStream.insertNumber(3);
        medianOfAStream.insertNumber(1);
        System.out.println("The median is: " + medianOfAStream.findMedian());
        medianOfAStream.insertNumber(5);
        System.out.println("The median is: " + medianOfAStream.findMedian());
        medianOfAStream.insertNumber(4);
        System.out.println("The median is: " + medianOfAStream.findMedian());
    }
}
