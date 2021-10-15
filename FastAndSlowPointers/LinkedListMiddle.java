package FastAndSlowPointers;

import FastAndSlowPointers.DTO.ListNodeDTO;

public class LinkedListMiddle {
    public static ListNodeDTO findMiddleNode(ListNodeDTO head) {
        ListNodeDTO slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNodeDTO head = new ListNodeDTO(1);
        head.next = new ListNodeDTO(2);
        head.next.next = new ListNodeDTO(3);
        head.next.next.next = new ListNodeDTO(4);
        head.next.next.next.next = new ListNodeDTO(5);
        System.out.println("Middle Node: " + findMiddleNode(head).value);
    
        head.next.next.next.next.next = new ListNodeDTO(6);
        System.out.println("Middle Node: " + findMiddleNode(head).value);
    
        head.next.next.next.next.next.next = new ListNodeDTO(7);
        System.out.println("Middle Node: " + findMiddleNode(head).value);
    }
}
