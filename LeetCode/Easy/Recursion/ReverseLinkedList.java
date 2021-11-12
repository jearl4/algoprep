package LeetCode.Easy.Recursion;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode temp = head;

        while (temp != null) {
            ListNode nextTemp = temp.next;
            temp.next = prev;
            prev = temp;
            temp = nextTemp;
        }

        return prev;
    }
}
