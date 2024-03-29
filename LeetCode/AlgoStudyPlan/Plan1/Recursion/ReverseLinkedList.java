package LeetCode.Easy.Recursion;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        public ListNode reverseList(ListNode head) {
            if(head == null || head.next == null){
                return head;
            }
            ListNode p = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return p;
        }
    }
}
