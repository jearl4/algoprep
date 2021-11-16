package LeetCode.General.BitManipulation;

import java.util.Stack;

public class ConvertBinaryInLinkedListToInteger {
    public int getDecimalValue(ListNode head) {
        int result = head.val;

        while (head.next != null) {
            result = result * 2 + head.next.val;
            head = head.next;
        }
        return result;
    }
}
