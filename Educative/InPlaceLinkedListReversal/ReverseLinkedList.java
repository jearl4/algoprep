import DTO.*;

public class ReverseLinkedList {
    public static ListNode reverseLinkedList(ListNode head) {
        ListNode previous = null;
        ListNode current = head;
        ListNode next = null;

        while(current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(10);
    
        ListNode result = reverseLinkedList(head);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
          System.out.print(result.value + " ");
          result = result.next;
        }
        System.out.println();
    }
}
