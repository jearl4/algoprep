import java.util.*;

import Tree.DTO.*;

public class ConnectLevelOrderSiblings {
    public static void connect(TreeNodeWithNextPointer root) {
        if (root == null) {
            return;
        }

        Queue<TreeNodeWithNextPointer> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            TreeNodeWithNextPointer previousNode = null;
            for (int i = 0; i < levelSize; i++) {
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
    }

    public static void main(String[] args) {
        TreeNodeWithNextPointer root = new TreeNodeWithNextPointer(12);
        root.left = new TreeNodeWithNextPointer(7);
        root.right = new TreeNodeWithNextPointer(1);
        root.left.left = new TreeNodeWithNextPointer(9);
        root.right.left = new TreeNodeWithNextPointer(10);
        root.right.right = new TreeNodeWithNextPointer(5);
        ConnectLevelOrderSiblings.connect(root);
        System.out.println("Level order traversal using 'next' pointer: ");
        root.printLevelOrder();
    }
}