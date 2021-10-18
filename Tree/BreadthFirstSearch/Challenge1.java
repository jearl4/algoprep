import java.util.*;
import Tree.DTO.TreeNodeWithNextPointer;

public class Challenge1 {
    public static void connect(TreeNodeWithNextPointer root) {
        if (root == null) {
            return;
        }

        Queue<TreeNodeWithNextPointer> queue = new LinkedList<>();
        queue.offer(root);
        TreeNodeWithNextPointer previousNode = null;
        while (!queue.isEmpty()) {
            TreeNodeWithNextPointer currentNode = queue.poll();
            if (previousNode != null) {
                previousNode.next = currentNode;
            }
            previousNode = currentNode;

            if (currentNode.left != null) {
                queue.offer(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.offer(currentNode.right);
            }
        }
    }

    public static void main(String[] args) {
        TreeNodeWithNextPointer root = new TreeNodeWithNextPointer(12);
        root.left = new TreeNodeWithNextPointer(7);
        root.right = new TreeNodeWithNextPointer(1);
        root.left.left = new TreeNodeWithNextPointer(9);
        root.right.left = new TreeNodeWithNextPointer(10);
        root.right.right = new TreeNodeWithNextPointer(5);
        connect(root);

        // level order traversal using 'next' pointer
        TreeNodeWithNextPointer current = root;
        System.out.println("Traversal using 'next' pointer: ");
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}
