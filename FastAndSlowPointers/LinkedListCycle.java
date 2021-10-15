package FastAndSlowPointers;

import FastAndSlowPointers.DTO.ListNodeDTO;

public class LinkedListCycle {
    public static boolean hasCycle(ListNodeDTO head) {
        ListNodeDTO slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListNodeDTO head = new ListNodeDTO(1);
        head.next = new ListNodeDTO(2);
        head.next.next = new ListNodeDTO(3);
        head.next.next.next = new ListNodeDTO(4);
        head.next.next.next.next = new ListNodeDTO(5);
        head.next.next.next.next.next = new ListNodeDTO(6);
        System.out.println("LinkedList has cycle: " + hasCycle(head));
    
        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList has cycle: " + hasCycle(head));
    
        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList has cycle: " + hasCycle(head));
      }
}
