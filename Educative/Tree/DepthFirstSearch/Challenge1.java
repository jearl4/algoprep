import DTO.TreeNode;

public class Challenge1 {
    private static int treeDiameter = 0;
    public static int findDiameter(TreeNode root) {
        findDiameterRecursive(root);
        return treeDiameter;
    }

    private static int findDiameterRecursive(TreeNode currentNode) {
        if(currentNode == null){
            return 0;
        }

        int leftTreeHeight = findDiameterRecursive(currentNode.left);
        int rightTreeHeight = findDiameterRecursive(currentNode.right);

        if (leftTreeHeight != 0 && rightTreeHeight != 0) {
            int diameter = leftTreeHeight + rightTreeHeight + 1;
            treeDiameter = Math.max(treeDiameter, diameter);
        }

        return Math.max(leftTreeHeight, rightTreeHeight) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        System.out.println("Tree Diameter: " + findDiameter(root));
        root.left.left = null;
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        root.right.left.right.left = new TreeNode(10);
        root.right.right.left.left = new TreeNode(11);
        System.out.println("Tree Diameter: " + findDiameter(root));
    }
}
