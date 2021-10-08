public class FastSlowChallenge1 {
    public static boolean isPalindrome(ListNodeDTO head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNodeDTO slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNodeDTO headSecondHalf = reverse(slow);
        ListNodeDTO copyHeadSecondHalf = headSecondHalf;

        while (head != null && headSecondHalf != null) {
            if(head.value != headSecondHalf.value){
                break;
            }
            head = head.next;
            headSecondHalf = headSecondHalf.next;
        }

        reverse(copyHeadSecondHalf);

        if (head == null || headSecondHalf == null) {
            return true;
        }
        return false;
    }

    private static ListNodeDTO reverse(ListNodeDTO head) {
        ListNodeDTO previous = null;
        while (head != null) {
            ListNodeDTO next = head.next;
            head.next = previous;
            previous = head;
            head = next;
        }
        return previous;
    }

    public static void main(String[] args) {
         ListNodeDTO head = new ListNodeDTO(2);
        head.next = new ListNodeDTO(4);
        head.next.next = new ListNodeDTO(6);
        head.next.next.next = new ListNodeDTO(4);
        head.next.next.next.next = new ListNodeDTO(2);
        System.out.println("Is palindrome: " + isPalindrome(head));

        head.next.next.next.next.next = new ListNodeDTO(2);
        System.out.println("Is palindrome: " + isPalindrome(head));
    }
}
