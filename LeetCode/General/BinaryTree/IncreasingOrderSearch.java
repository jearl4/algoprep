package LeetCode.General.BinaryTree;

import java.util.ArrayList;
import java.util.List;

import Educative.Tree.DTO.TreeNode;



public class IncreasingOrderSearch {
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> vals = new ArrayList<>();
        inOrder(root, vals);
        TreeNode ans = new TreeNode(0), currentTree = ans;
        for (int v : vals) {
            currentTree.right = new TreeNode(v);
            currentTree = currentTree.right;
        }
        return ans.right;
    }

    public void inOrder(TreeNode node, List<Integer> vals) {
        if (node == null) {
            return;
        }

        inOrder(node.left, vals);
        vals.add(node.val);
        inOrder(node.right, vals);
    }
}
