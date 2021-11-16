package LeetCode.General.BitManipulation;

import java.util.Stack;

public class ConvertBinaryInLinkedListToInteger {
    public int getDecimalValue(ListNode head) {
        int result = 0;
        Stack<Integer> stack = new Stack<>();

        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }

        int powerOfTwo = 1;
        while (!stack.isEmpty()) {
            result += (stack.pop() * powerOfTwo);
            powerOfTwo *= 2;
        }
        return result;
    }
}
