import DTO.TreeNode;

public class Challenge2 {
    private static int maxSum = 0;
    public static int FindMaxSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        findMaxSumRecursive(root);
        return maxSum;
    }

    private static int findMaxSumRecursive(TreeNode currentNode) {
        if (currentNode == null) {
            return 0;
        }

        int maxPathSumFromLeft = findMaxSumRecursive(currentNode.left);
        int maxPathSumFromRight = findMaxSumRecursive(currentNode.right);

        maxPathSumFromLeft = Math.max(maxPathSumFromLeft, 0);
        maxPathSumFromRight = Math.max(maxPathSumFromRight, 0);

        int localMaxSum = maxPathSumFromLeft + maxPathSumFromRight + currentNode.val;
        maxSum = Math.max(maxSum, localMaxSum);
        
        return Math.max(maxPathSumFromLeft, maxPathSumFromRight) + currentNode.val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println("Maximum Path Sum: " + FindMaxSum(root));
        
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        System.out.println("Maximum Path Sum: " + FindMaxSum(root));
        
        root = new TreeNode(-1);
        root.left = new TreeNode(-3);
        System.out.println("Maximum Path Sum: " + FindMaxSum(root));
    }
}
