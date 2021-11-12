import DTO.*;

public class FindPath {
    public static boolean isPathFound(TreeNode root, int[] path) {
        if (root == null) {
            return path.length == 0;
        }
        
        return findPathRecursive(root, path, 0);
    }

    private static boolean findPathRecursive(TreeNode currentNode, int[] path, int index) {
        if (currentNode == null) {
            return false;
        }

        if (index >= path.length || currentNode.val != path[index]) {
            return false;
        }

        if (currentNode.left == null && currentNode.right == null && index == path.length - 1) {
            return true;
        }

        return findPathRecursive(currentNode.left, path, index + 1) || findPathRecursive(currentNode.right, path, index + 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);

        System.out.println("Tree has path sequence: " + isPathFound(root, new int[] { 1, 0, 7 }));
        System.out.println("Tree has path sequence: " + isPathFound(root, new int[] { 1, 1, 6 }));
    }
}
