package Tree.DTO;

public class TreeNodeWithNextPointer {
    int val;
    TreeNodeWithNextPointer left;
    TreeNodeWithNextPointer right;
    TreeNodeWithNextPointer next;

    TreeNodeWithNextPointer(int x) {
        val = x;
        left = right = next = null;
    }

    // level order traversal using 'next' pointer
    void printLevelOrder() {
        TreeNodeWithNextPointer nextLevelRoot = this;
        while (nextLevelRoot != null) {
            TreeNodeWithNextPointer current = nextLevelRoot;
            nextLevelRoot = null;
            while (current != null) {
                System.out.print(current.val + " ");
                if (nextLevelRoot == null) {
                    if (current.left != null)
                        nextLevelRoot = current.left;
                    else if (current.right != null)
                        nextLevelRoot = current.right;
                }
                current = current.next;
            }
            System.out.println();
        }
    }
};
