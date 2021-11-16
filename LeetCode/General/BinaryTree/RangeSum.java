package LeetCode.General.BinaryTree;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class RangeSum {
    int sum;

    public int rangeSumBST(TreeNode root, int low, int high) {
        sum = 0;
        dfs(root, low, high);
        return sum;
    }

    public void dfs(TreeNode node, int low, int high) {
        if (node != null) {
            if (node.val >= low && node.val <= high) {
                sum += node.val;
            }

            if (node.val > low) {
                dfs(node.left, low, high);
            }

            if (node.val < high) {
                dfs(node.right, low, high);
            }
        }
    }
}
