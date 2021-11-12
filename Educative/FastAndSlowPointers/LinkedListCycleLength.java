package Educative.FastAndSlowPointers;

import Educative.FastAndSlowPointers.DTO.ListNodeDTO;

public class LinkedListCycleLength {
    public static int findCycleLength(ListNodeDTO head) {
        ListNodeDTO slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast){
                return calculateLength(slow);
            }
        }
        return 0;
    }

    private static int calculateLength(ListNodeDTO slow) {
        ListNodeDTO current = slow;
        int cycleLength = 0;
        do {
            current = current.next;
            cycleLength++;
        } while (current != slow);
        return cycleLength;
    }

    public static void main(String[] args) {
        ListNodeDTO head = new ListNodeDTO(1);
        head.next = new ListNodeDTO(2);
        head.next.next = new ListNodeDTO(3);
        head.next.next.next = new ListNodeDTO(4);
        head.next.next.next.next = new ListNodeDTO(5);
        head.next.next.next.next.next = new ListNodeDTO(6);
        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList cycle length: " + LinkedListCycleLength.findCycleLength(head));
    
        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList cycle length: " + LinkedListCycleLength.findCycleLength(head));
      }
}
