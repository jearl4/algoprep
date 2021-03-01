package LinkedList;

/* given a sorted linked list remove all dupes and return in sorted order */
public class RemoveSortedDupes {
    public static class LinkedList{
        public int value;
        public LinkedList next;
    }

    public LinkedList removeDupes(LinkedList linkedList){
        LinkedList currentNode = linkedList;

        while (currentNode != null) {
            LinkedList nextDistinctNode = currentNode.next;
            while (nextDistinctNode != null && nextDistinctNode.value == currentNode.value) {
                nextDistinctNode = nextDistinctNode.next;
            }
            currentNode.next = nextDistinctNode;
            currentNode = nextDistinctNode;
        }
        return linkedList;
    }
}
