package LeetCode.General.BinaryTree;

import Educative.Tree.DTO.TreeNode;

public class MaximumDepth {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        } else {
            int leftHeight = maxDepth(root.left);
            int rightHeight = maxDepth(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}
