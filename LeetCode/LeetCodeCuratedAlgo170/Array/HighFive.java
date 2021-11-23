package LeetCode.LeetCodeCuratedAlgo170.Array;

import java.util.Stack;

public class HighFive {
    public int[][] highFive(int[][] items) {
        Stack<Integer> stack = new Stack<>((n1, n2) -> n2 - n1);
        int sum = 0;
        
        for(int i = 0; i < items.length; i++){
            stack.push(items[i][1]);
        }
        
        for(int i = 0; i < 5; i++){
            sum += stack.pop();
        }
        
        return sum / 5;
    }
}
