package LeetCode.Medium.TwoPointers;

public class RemoveNthElementFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        
        for(int i = 1; i <= n + 1; i++){
            fast = fast.next;
        }
        
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        
        slow.next = slow.next.next;
        return dummy.next;
    }
}
}
