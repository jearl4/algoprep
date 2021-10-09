public class FastSlowChallenge2 {
    public static void shuffle(ListNodeDTO head) {
        if(head == null || head.next == null){
            return;
        }

        ListNodeDTO middle = findMiddle(head);
        
        ListNodeDTO headSecondHalf = reverse(middle);
        ListNodeDTO headFirstHalf = head;

        while (headFirstHalf != null && headSecondHalf != null) {
            ListNodeDTO temp = headFirstHalf.next;
            headFirstHalf.next = headSecondHalf;
            headFirstHalf = temp;

            temp = headSecondHalf.next;
            headSecondHalf.next = headFirstHalf;
            headSecondHalf = temp;
        }

        if (headFirstHalf != null) {
            headFirstHalf.next = null;
        }
    }

    private static ListNodeDTO reverse(ListNodeDTO head) {
        ListNodeDTO prev = null;
        while (head != null) {
            ListNodeDTO next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    private static ListNodeDTO findMiddle(ListNodeDTO head) {
        ListNodeDTO slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    public static void main(String[] args) {
        ListNodeDTO head = new ListNodeDTO(2);
        head.next = new ListNodeDTO(4);
        head.next.next = new ListNodeDTO(6);
        head.next.next.next = new ListNodeDTO(8);
        head.next.next.next.next = new ListNodeDTO(10);
        head.next.next.next.next.next = new ListNodeDTO(12);
        shuffle(head);
        while (head != null) {
        System.out.print(head.value + " ");
        head = head.next;
    }
    }
}
