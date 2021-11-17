package LeetCode.General.BinaryTree;

import Educative.Tree.DTO.TreeNode;

public class SearchBST {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || val == root.val) {
            return root;
        }
        if (val < root.val) {
            return searchBST(root.left, val);
        }
        return searchBST(root.right, val);
    }
}
