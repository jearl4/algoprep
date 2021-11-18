package LeetCode.General.BinaryTree;

import Educative.Tree.DTO.TreeNode;

public class MaximumDepth {
    int bestSum = 0, currentSum = 0;

    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        currentSum++;

        if (root.left != null)
            maxDepth(root.left);

        if (root.right != null)
            maxDepth(root.right);

        if (root.right == null && root.left == null) {
            if (currentSum > bestSum) {
                bestSum = currentSum;
            }
        }
        currentSum--;

        return bestSum;
    }
}
