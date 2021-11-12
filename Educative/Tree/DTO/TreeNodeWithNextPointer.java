package DTO;

public class TreeNodeWithNextPointer {
    public int val;
    public TreeNodeWithNextPointer left;
    public TreeNodeWithNextPointer right;
    public TreeNodeWithNextPointer next;

    public TreeNodeWithNextPointer(int x) {
        val = x;
        left = right = next = null;
    }

    // level order traversal using 'next' pointer
    public void printLevelOrder() {
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
