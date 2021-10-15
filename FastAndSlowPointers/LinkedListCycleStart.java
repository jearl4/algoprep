package FastAndSlowPointers;

import FastAndSlowPointers.DTO.ListNodeDTO;

public class LinkedListCycleStart {
    public static ListNodeDTO cycleStart(ListNodeDTO head) {
        int cycleLength = 0;
        ListNodeDTO slow = head, fast = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                ListNodeDTO current = slow;
                do {
                    current = current.next;
                    cycleLength++;
                } while (current != slow);
                break;
            }
        }
        return findStart(head, cycleLength);
    }

    private static ListNodeDTO findStart(ListNodeDTO head, int cycleLength) {
        ListNodeDTO pointer1 = head, pointer2 = head;
        while (cycleLength > 0) {
            pointer2 = pointer2.next;
            cycleLength--;
        }

        while (pointer1 != pointer2) {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }
        return pointer1;
    }

    public static void main(String[] args) {
        ListNodeDTO head = new ListNodeDTO(1);
        head.next = new ListNodeDTO(2);
        head.next.next = new ListNodeDTO(3);
        head.next.next.next = new ListNodeDTO(4);
        head.next.next.next.next = new ListNodeDTO(5);
        head.next.next.next.next.next = new ListNodeDTO(6);
    
        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList cycle start: " + cycleStart(head).value);
    
        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList cycle start: " + cycleStart(head).value);
    
        head.next.next.next.next.next.next = head;
        System.out.println("LinkedList cycle start: " + cycleStart(head).value);
      }
}
